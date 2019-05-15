package model;

public class Association extends Relation {


	private String multipliciteIn;
	private String multipliciteOut;
	private String libelle;
	
	
	public Association(String type, String multipliciteIn, String multipliciteOut, String libelle) {
		super(type);
		this.multipliciteIn = multipliciteIn;
		this.multipliciteOut = multipliciteOut;
		this.libelle = libelle;
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
