package Scraping;

public class Entreprise extends Parent {
	//----------------------------------------Fields-------------------------
	private String title;
	private String logo;
	private String website;
	private String secteur;
	
	
	//----------------------------------------Constructor-------------------------
	public Entreprise() {
		super();
		this.logo = "";
		this.website = "";
		this.secteur = "";
	}
	public Entreprise(String title, String logo, String website, String secteur) {
		super(title);
		this.logo = logo;
		this.website = website;
		this.secteur = secteur;
	}
	//----------------------------------------Getters-------------------------
	public String getTitle() {
		return title;
	}
	public String getLogo() {
		return logo;
	}
	public String getWebsite() {
		return website;
	}
	public String getSecteur() {
		return secteur;
	}
	
	//----------------------------------------Setters-------------------------
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	
	

}

