package Scraping;

import java.io.IOException;
import java.sql.SQLException;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Remplissage {
	
			// this function scrap the description page
			public static ArrayList<String> scrapeDescriptionPage(String url, Entreprise entreprise, Offre offre, ArrayList<String> statement) {
				try {
				
					// Get the description page content
					Document documentDescription = Jsoup.connect(url).get();
										
					//------------------------------------ Enterprise-------------------------------------------
					// get the header of the description "Title of the Offer, Company's name -  City"
					Elements entrepriseElement = documentDescription.getElementsByAttributeValueContaining("id", "company-profile");
				
					Elements entrepriseInfos = entrepriseElement.select("div.job-ad-company");
					
					// set the title of the offre
					offre.setTitle(documentDescription.select("h1.title").text().replace("'","''"));
					
					// set the title of the company
					entreprise.setTitle(entrepriseInfos.select("div.company-title > a").text().replace("'","''")); 
					// set the logo of the company
					entreprise.setLogo(entrepriseInfos.select("div.company-logo > img").attr("src").replace("'","''"));
					

					
					for (Element lignes : entrepriseInfos.select("table.company-info > tbody > tr") ) {
						if(lignes.select("td.website-url > a").text().equals("")){
							continue;
						}
						else {
							// set the website of the company
							entreprise.setWebsite(lignes.select("td.website-url > a").text().replace("'","''"));
						}
					}
					
					for (Element lignes : entrepriseInfos.select("table.company-info > tbody > tr") ) {
						if(lignes.select("div.field-item.even").text().equals("")){
							continue;
						}
						else {
							// set the sector of the company
							entreprise.setSecteur(lignes.select("div.field-item.even").text().replace("'","''"));
							
						}
					}
							
					//------------------------------------- Announce-------------------------------------------
					
					offre.setEntreprise(entreprise);
					Elements announceElement = documentDescription.getElementsByAttributeValueContaining("id", "job-ad-details");
					
					
					for (Element row : announceElement.select("div.content.clearfix")) {
						if(row.child(0).select("li").size() > 0) {
							// set the mission of the company
							offre.setMissions(row.child(0).select("li").text().replace("'","''"));
													}
						else {
							// set the mission of the company
							offre.setMissions(row.child(0).select("p").text().replace("'","''"));							
						}
					}
					
					for (Element row : announceElement.select("div.content.clearfix")) {
						if(row.child(2).select("li").size() > 0) {
							offre.setProfil(row.child(2).select("li").text().replace("'","''"));
						}
						else {
							offre.setProfil(row.child(2).select("p").text().replace("'","''"));
						}
					}
					
					// Crit�res de l'annonce pour le poste
					
					for (Element row : announceElement.select("table.job-ad-criteria tr")) {

						if (row.child(0).text().equals("M�tier :"))
						{
							if( row.select("div.field-items").size() == 0) {
								offre.setMetier(row.child(1).text().replace("'","''"));								
							}else {
								offre.setMetier(row.child(1).text().replace("'","''"));
							}
						}
						if (row.child(0).text().equals("Secteur d�activit� :"))
						{
							if( row.select("div.field-items").size() == 0) {
								
								offre.setSecteur(row.child(1).text().replace("'","''"));
							}else {
								
								offre.setSecteur(row.select("div.field-items").text().replace("'","''"));
							}
						}
						if (row.child(0).text().equals("Type de contrat :"))
						{
							if( row.select("div.field-items").size() == 0) {
								offre.setTypeContrat(row.child(1).text().replace("'","''"));
							}else {
								offre.setTypeContrat(row.select("div.field-items").text().replace("'","''"));
							}
						}
						if (row.child(0).text().equals("R�gion :"))
						{
							if( row.select("div.field-items").size() == 0) {
								offre.setRegion(row.child(1).text().replace("'","''"));
							}else {
								offre.setRegion(row.select("div.field-items").text().replace("'","''"));
							}
						}
						if (row.child(0).text().equals("Ville :"))
						{
							if( row.select("div.field-items").size() == 0) {
								offre.setVille(row.child(1).text().replace("'","''"));
							}else {
								offre.setVille(row.select("div.field-items").text().replace("'","''"));
							}
						}
						if (row.child(0).text().equals("Niveau d'exp�rience :"))
						{
							if( row.select("div.field-items").size() == 0) {
								offre.setNiveauExperience(row.child(1).text().replace("'","''"));
							}else {
								offre.setNiveauExperience(row.select("div.field-items").text().replace("'","''"));
							}
						}
						if (row.child(0).text().equals("Niveau d'�tudes :"))
						{
							if( row.select("div.field-items").size() == 0) {
								offre.setNiveauEtude(row.child(1).text().replace("'","''"));
							}else {
								offre.setNiveauEtude(row.select("div.field-items").text().replace("'","''"));
							}
						}
						if (row.child(0).text().equals("Langues exig�es :"))
						{
							if( row.select("div.field-items").size() == 0) {
								offre.setLangues(row.child(1).text().replace("'","''"));
								//System.out.println("\t\t" + row.child(1).text());
							}else {
								offre.setLangues(row.select("div.field-items").text().replace("'","''"));
								//System.out.println("\t\t" +row.select("div.field-items").text());
							}
						}
						if (row.child(0).text().equals("Nombre de poste(s) :"))
						{
							if( row.select("div.field-items").size() == 0) {
		
								final int nbr = Integer.parseInt(row.child(1).text().replace("'","''"));
								offre.setNombrePoste(nbr);								
							}else {
								
								final int nbr = Integer.parseInt(row.select("div.field-items").text().replace("'","''"));
								offre.setNombrePoste(nbr);
							}
						} 
					}
					
					statement.add(" INSERT INTO entreprise (title,logo,website,secteur) VALUES ('"+entreprise.getTitle()+"','"+entreprise.getLogo()+"','"+entreprise.getWebsite()+"', '"+entreprise.getSecteur()+"') ");
					statement.add("INSERT INTO offre (entreprise, title, missions, profil, metier, secteur, typeContrat, region, ville, niveauExperience, niveauEtude, langues, nombrePoste) VALUES ('"+offre.getEntreprise()+"','"+offre.getTitle()+"','"+offre.getMissions()+"','"+offre.getProfil()+"','"+offre.getMetier()+"','"+offre.getSecteur()+"','"+offre.getTypeContrat()+"','"+offre.getRegion()+"','"+offre.getVille()+"','"+offre.getNiveauExperience()+"','"+offre.getNiveauEtude()+"','"+offre.getLangues()+"','"+offre.getNombrePoste()+"') ");
					return statement ;

		
				}catch(IOException ioe){
				    System.out.println("Unable to connect to the URL");
				    ioe.printStackTrace();
				    
				    return null;
				}
			}
			
			
			public static void main(String[] args) throws SQLException {
				
				// -------------------------------------------local-fields-----------------------------
				ConnectDB connect = new ConnectDB();
				Entreprise entreprise = new Entreprise();
				Offre offre = new Offre(entreprise);
				Document document = new Document(null);
				ArrayList<String> querySql = new ArrayList<String>();
				
				String url = "https://www.emploi.ma/recherche-jobs-maroc/Informatique";
				 
					try{				
						for (int i=0 ; i < 13 ; i++ ) {
						//Get content the google home page using Jsoup
						document = Jsoup.connect(url).get();
					    
						//get the description page of the offers
					    Elements links = document.select("div.job-description-wrapper");
					    
					    for (Element link : links ) {
					    	String childElementsUrl = link.attr("data-href");
					    	
					    	querySql = scrapeDescriptionPage(childElementsUrl,entreprise,offre,querySql);
				    		for (String statement : querySql) {
				    			connect.edit(statement);
				    		} 	
					    }

					    Elements nextPageElement = document.select("li.pager-next.active.last > a");
					    url = nextPageElement.attr("abs:href");
					    System.out.println(url);
						}
						
					}catch(IOException | SQLException ioe){
					    ioe.printStackTrace();
					}
			}
			
		}
	
