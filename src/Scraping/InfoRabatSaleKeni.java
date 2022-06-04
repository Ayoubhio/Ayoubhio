package Scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class InfoRabatSaleKeni {
	
	// this function scrap the description page
	public static void scrapeDescriptionPage(String url) {
		try {
			// Get the description page content
			Document documentDescription = Jsoup.connect(url).get();
			
			//------------------------------------ Enterprise-------------------------------------------
			// get the header of the description "Title of the Offer, Company's name -  City"
			Elements entrepriseElement = documentDescription.getElementsByAttributeValueContaining("id", "company-profile");
			
			Elements entrepriseInfos = entrepriseElement.select("div.job-ad-company");
			
			System.out.println("L'offre : "
					+"\n\tTitre de l'offre : "
					+ documentDescription.select("h1.title").text() 
					+"\n\t----------------------------Enterprise----------------------------"
					+ "\n\tCompany title : "
					+ entrepriseInfos.select("div.company-title > a").text()
					+ "\n\tCompany logo : "
					+ entrepriseInfos.select("div.company-logo > img").attr("src")
					);
			
			for (Element lignes : entrepriseInfos.select("table.company-info > tbody > tr") ) {
				if(lignes.select("td.website-url > a").text().equals("")){
					continue;
				}
				else {
					System.out.println(
							"\tSite Internet : " 
							+lignes.select("td.website-url > a").text() );
				}
			}
			
			for (Element lignes : entrepriseInfos.select("table.company-info > tbody > tr") ) {
				if(lignes.select("div.field-item.even").text().equals("")){
					continue;
				}
				else {
					System.out.println(
							"\tSecteur d'activite : " 
							+ lignes.select("div.field-item.even").text());
				}
			}
					
			//------------------------------------- Announce-------------------------------------------
			
			Elements announceElement = documentDescription.getElementsByAttributeValueContaining("id", "job-ad-details");
			
			System.out.println(
					"\n\t----------------------------Announce----------------------------\n\t"
					+ announceElement.select("span.ad-ss-title").text()
					);
			
			System.out.println("\tMissions : ");
			for (Element row : announceElement.select("div.content.clearfix")) {
				if(row.child(0).select("li").size() > 0) {
					System.out.println("\t\t"+row.child(0).select("li").text().replace("Missions :", ""));
				}
				else {
					System.out.println("\t\t"+row.child(0).select("p").text().replace("Missions :", ""));
				}
			}
			
			System.out.println("\tProfil recherch� pour le poste : ");
			for (Element row : announceElement.select("div.content.clearfix")) {
				if(row.child(2).select("li").size() > 0) {
					System.out.println("\t\t"+row.child(2).select("li").text());
				}
				else {
					System.out.println("\t\t"+row.child(2).select("p").text());
				}
			}
			
			// Crit�res de l'annonce pour le poste
			
			System.out.println("\n\tCrit�res de l'annonce pour le poste : ");
			for (Element row : announceElement.select("table.job-ad-criteria tr")) {

				if (row.child(0).text().equals("M�tier :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				}
				if (row.child(0).text().equals("Secteur d�activit� :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				}
				if (row.child(0).text().equals("Type de contrat :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				}
				if (row.child(0).text().equals("R�gion :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				}
				if (row.child(0).text().equals("Ville :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				}
				if (row.child(0).text().equals("Niveau d'exp�rience :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				}
				if (row.child(0).text().equals("Niveau d'�tudes :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				}
				if (row.child(0).text().equals("Langues exig�es :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				}
				if (row.child(0).text().equals("Nombre de poste(s) :"))
				{
					System.out.println("\t" + row.child(0).text());
					if( row.select("div.field-items").size() == 0) {
						System.out.println("\t\t" + row.child(1).text());
					}else {
						System.out.println("\t\t" +row.select("div.field-items").text());
					}
				} 
			}		
			System.out.println("\n_______________________________________________________________________________________________________________________________________");
					
		}catch(IOException ioe){
		    System.out.println("Unable to connect to the URL");
		    ioe.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		String url = "https://www.emploi.ma/recherche-jobs-maroc/Informatique?f%5B0%5D=im_field_offre_region:64";
		for (int i=0 ; i <2  ; i++ ) {
			try{
				//Get content the google home page using Jsoup
				Document document = Jsoup.connect(url).get();
			    
			    //get the description page of the offers
			    Elements links = document.select("div.job-description-wrapper");
			    
			    for (Element link : links ) {
			    	
			    	String childElementsUrl = link.attr("data-href");
			    	
			    	scrapeDescriptionPage(childElementsUrl);
			    	
			    }
			    
			    Elements nextPageElement = document.select("li.pager-next.active.last > a");
			    url = nextPageElement.attr("abs:href");
				
			}catch(IOException ioe){
			    System.out.println("Unable to connect to the URL");
			    ioe.printStackTrace();
			}
		}
	}
	
}

