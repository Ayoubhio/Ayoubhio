package machine;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import weka.core.Instances;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;
import java.sql.Statement;

public class clustering
{
	
	public static void main(String[] args) throws Exception
	{
		final Instances data = new Instances(new BufferedReader(new FileReader("autres/data.arff")));
		EM model = new EM();
		
		model.buildClusterer(data);
		System.out.println(model);
		
		double logLikelihood = ClusterEvaluation.crossValidateModel(model, data, 10, new Random(1));
		System.out.println(logLikelihood);	
	}
}