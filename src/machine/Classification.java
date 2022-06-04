package machine;

import javax.swing.JFrame;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug.Random;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
//supervised method
public class Classification 
{
	
	public String predict (double a, double b , double c , double d , double e , double f) throws Exception
	{
		
        DataSource source = new DataSource("autres/data.arff");
		Instances data = source.getDataSet();
		System.out.println(data.numInstances() + " instances loaded.");

		// remove nombre de poste attribute
		String[] opts = new String[] { "-R", "8" };
		Remove remove = new Remove();
		remove.setOptions(opts);
		remove.setInputFormat(data);
		data = Filter.useFilter(data, remove);

		data.setClassIndex(data.numAttributes()-6); //to predict job
		
		/*
		 * Feature selection automatique classify useful attributes that will help us
		 */
		AttributeSelection attSelect = new AttributeSelection();
		InfoGainAttributeEval eval = new InfoGainAttributeEval();
		Ranker search = new Ranker(); // to solve ranking problems typically supervised, semi-supervised or reinforcement learning
		attSelect.setEvaluator(eval); //They split the input data into separate training and test datasets.
		attSelect.setSearch(search); 
		attSelect.SelectAttributes(data);
		int[] indices = attSelect.selectedAttributes();
		System.out.println("Selected attributes: "+Utils.arrayToString(indices));		
		/*
		 * Build a decision tree
		 */
		
		String[] options = new String[1];
		options[0] = "-U";
		J48 tree = new J48();
		tree.setOptions(options);
		tree.buildClassifier(data);
		System.out.println(tree);

		/*
		 * Classify new instance.
		 */
        //input
		double[] vals = new double[data.numAttributes()];
		vals[0] = a; // societe {false, true}
		vals[1] = b; // type_contrat {false, true}
		vals[3] = c; // region {false, true}
		vals[4] = d; // niveau experience {false, true}
		vals[5] = e; // niveau etude {false, true}
		vals[6] = f; // langue {false, true}
		Instance myUnicorn = new DenseInstance(1.0, vals);
		//Assosiate your instance with Instance object in this case dataRaw
		myUnicorn.setDataset(data); 

		double label = tree.classifyInstance(myUnicorn);

		Classifier cl = new J48();
		Evaluation eval_roc = new Evaluation(data);
		eval_roc.crossValidateModel(cl, data, 10, new Random(1), new Object[] {});
		System.out.println(eval_roc.toSummaryString());
		// Confusion matrix
		double[][] confusionMatrix = eval_roc.confusionMatrix();
		System.out.println(eval_roc.toMatrixString());
		
		return data.classAttribute().value((int) label); // output dans l'interface
	}
	
//	   public static void main(String[] args) throws Exception {
//
//					/*
//					 * Load the data
//					 */
//		            DataSource source = new DataSource("autres/data.arff");
//					Instances data = source.getDataSet();
//					System.out.println(data.numInstances() + " instances loaded.");
//					// System.out.println(data.toString());
//
//					// remove nombre de poste attribute
//					String[] opts = new String[] { "-R", "8" };
//					Remove remove = new Remove();
//					remove.setOptions(opts);
//					remove.setInputFormat(data);
//					data = Filter.useFilter(data, remove);
//					
//					opts = new String[] { "-R", "6" };
//					remove = new Remove();
//					remove.setOptions(opts);
//					remove.setInputFormat(data);
//					data = Filter.useFilter(data, remove);
//					data.setClassIndex(data.numAttributes()-5);
//					/*
//					 * Feature selection class les attributs utiles
//					 */
//					AttributeSelection attSelect = new AttributeSelection();
//					InfoGainAttributeEval eval = new InfoGainAttributeEval();
//					Ranker search = new Ranker();
//					attSelect.setEvaluator(eval);
//					attSelect.setSearch(search);
//					attSelect.SelectAttributes(data);
//					int[] indices = attSelect.selectedAttributes();
//					System.out.println("Selected attributes: "+Utils.arrayToString(indices));
//
//					/*
//					 * Build a decision tree
//					 */
//					String[] options = new String[1];
//					options[0] = "-U";
//					J48 tree = new J48();
//					tree.setOptions(options);
//					tree.buildClassifier(data);
//					System.out.println(tree);
//
//					/*
//					 * Classify new instance.
//					 */
//			        //input
//					double[] vals = new double[data.numAttributes()];
//					vals[0] = 30.0; // societe {false, true}
//					vals[1] = 14.0; // metier {false, true}
//					vals[3] = 7.0; // region {false, true}
//					vals[4] = 2.0; // niveau experience {false, true}
//					vals[5] = 4.0; // niveau etude {false, true}
//					vals[6] = 2.0; // langue {false, true}
//					Instance myUnicorn = new DenseInstance(1.0, vals);
//					//Assosiate your instance with Instance object in this case dataRaw
//					myUnicorn.setDataset(data); 
//
//					double label = tree.classifyInstance(myUnicorn);
//					System.out.println("The instance: " + myUnicorn);
//					System.out.println(data.classAttribute().value((int) label)); // output dans l'interface
//
//					/*
//					 * Visualize decision tree
//					 */
//					TreeVisualizer tv = new TreeVisualizer(null, tree.graph(),new PlaceNode2());
//					JFrame frame = new javax.swing.JFrame("Tree Visualizer");
//					frame.setSize(800, 500);
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					frame.getContentPane().add(tv);
//					frame.setVisible(true);
//					tv.fitToScreen();
//
//					Classifier cl = new J48();
//					Evaluation eval_roc = new Evaluation(data);
//					eval_roc.crossValidateModel(cl, data, 10, new Random(1), new Object[] {});
//					System.out.println(eval_roc.toSummaryString());
//					// Confusion matrix
//					double[][] confusionMatrix = eval_roc.confusionMatrix();
//					System.out.println(eval_roc.toMatrixString());
//
//				}
		}

