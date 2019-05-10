package model;

public class MethodeU2J {

	private String nom;
	private String visibilite;
	private String type;
	
	public MethodeU2J(String nom, String visibilite, String type) {
		this.nom = nom;
		this.visibilite = visibilite;
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
