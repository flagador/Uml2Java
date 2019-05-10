package model;

public class Attribut {

	private String nom;
	private String type;
	private String visibilite;
	
	public Attribut(String nom, String type, String visibilite) {
		super();
		this.nom = nom;
		this.type = type;
		this.visibilite = visibilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}


	
	
	
}
