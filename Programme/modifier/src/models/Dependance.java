package models;

public class Dependance extends Relation {
	private Classe classeDep;
	private Classe classeDest;
	private String libelle;

	public Dependance(Classe classeDep, Classe classeDest ,String type, String libelle) {
		super(type);
		this.libelle = libelle;
		this.classeDep = classeDep;
		this.classeDest = classeDest;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Classe getClasseDep() {
		return classeDep;
	}


	public void setClasseDep(Classe classeDep) {
		this.classeDep = classeDep;
	}


	public Classe getClasseDest() {
		return classeDest;
	}


	public void setClasseDest(Classe classeDest) {
		this.classeDest = classeDest;
	}
	
}
