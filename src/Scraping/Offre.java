package Scraping;

public class Offre extends Parent {
	//----------------------------------------Fields-------------------------
	private Entreprise entreprise ;
	private String missions;
	private String profil;
	private String metier;
	private String secteur;
	private String typeContrat;
	private String region;
	private String ville;
	private String niveauExperience;
	private String niveauEtude;
	private String langues;
	private int nombrePoste;
	
	
	//----------------------------------------Constructors-------------------------
	
	
	public Offre(Entreprise entreprise, String title, String missions, String profil, String metier, String secteur,
			String typeContrat, String region, String ville, String niveauExperience, String niveauEtude,
			String langues, int nombrePoste) {
		super(title);
		this.entreprise = entreprise;
		this.missions = missions;
		this.profil = profil;
		this.metier = metier;
		this.secteur = secteur;
		this.typeContrat = typeContrat;
		this.region = region;
		this.ville = ville;
		this.niveauExperience = niveauExperience;
		this.niveauEtude = niveauEtude;
		this.langues = langues;
		this.nombrePoste = nombrePoste;
	}
	public Offre(Entreprise entreprise) {
		
		this.entreprise = entreprise;
		this.missions = "";
		this.profil = "";
		this.metier = "";
		this.secteur = "";
		this.typeContrat = "";
		this.region = "";
		this.ville = "";
		this.niveauExperience = "";
		this.niveauEtude = "";
		this.langues = "";
		this.nombrePoste = 0;
	}
	//----------------------------------------Getters-------------------------
	public String getEntreprise() {
		return entreprise.getTitle();
	}
	public String getMissions() {
		return missions;
	}
	public String getProfil() {
		return profil;
	}
	public String getMetier() {
		return metier;
	}
	public String getSecteur() {
		return secteur;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public String getRegion() {
		return region;
	}
	public String getVille() {
		return ville;
	}
	public String getNiveauExperience() {
		return niveauExperience;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public String getLangues() {
		return langues;
	}
	public int getNombrePoste() {
		return nombrePoste;
	}
	
	//----------------------------------------Setters-------------------------
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public void setMissions(String missions) {
		this.missions = missions;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public void setMetier(String metier) {
		this.metier = metier;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setNiveauExperience(String niveauExperience) {
		this.niveauExperience = niveauExperience;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	public void setLangues(String langues) {
		this.langues = langues;
	}
	public void setNombrePoste(int nombrePoste) {
		this.nombrePoste = nombrePoste;
	}


}

