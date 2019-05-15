package model;

public class Dependance extends Relation {

	private String libelle;

	public Dependance(String type, String libelle) {
		super(type);
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
