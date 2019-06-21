package models;

public class Association extends Relation {

	private Classe classeDep;
	private Classe classeDest;
	private String multipliciteIn;
	private String multipliciteOut;
	private String libelle;
	
	
	public Association(Classe classeDep, Classe classeDest, String type, String multipliciteIn, String multipliciteOut, String libelle) {
		super(type);
		this.classeDep = classeDep;
		this.classeDest = classeDest;
		this.multipliciteIn = multipliciteIn;
		this.multipliciteOut = multipliciteOut;
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


	public String getMultipliciteIn() {
		return multipliciteIn;
	}

	public void setMultipliciteIn(String multipliciteIn) {
		this.multipliciteIn = multipliciteIn;
	}

	public String getMultipliciteOut() {
		return multipliciteOut;
	}

	public void setMultipliciteOut(String multipliciteOut) {
		this.multipliciteOut = multipliciteOut;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
    public String traductionJava() {
    	String associationJava = "";
    	
    	
    	
    	
    	return associationJava;
    }

	
	

}
