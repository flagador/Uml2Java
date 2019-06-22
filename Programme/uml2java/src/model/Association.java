package model;

public class Association extends Relation {

	private Classe classeDep;
	private Classe classeDest;
	private String multipliciteIn;
	private String multipliciteOut;
	private String libelle;
	
	
	public Association(Classe classeDep, Classe classeDest, String multipliciteIn, String multipliciteOut, String libelle) {
		super("association");
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
	
    
	public void unAun(String nomObjetDest, String nomObjetDep){
		
		Attribut a = new Attribut(nomObjetDest.toLowerCase(), this.classeDest.getNom(), "public");
		this.classeDep.ajoutAttribut(a);
		
		Attribut b = new Attribut(nomObjetDep.toLowerCase(), this.classeDep.getNom(), "public");
		this.classeDest.ajoutAttribut(b);
		
	}
	
	public void unAn(String nomObjetDest, String nomObjetDep) {
		
		String arraylist = "ArrayList<"+this.classeDest.getNom()+">";
		Attribut a = new Attribut(nomObjetDest.toLowerCase(), arraylist, "public");
		
		this.classeDep.ajoutAttribut(a);
		
		Attribut b = new Attribut(nomObjetDep.toLowerCase(), this.classeDep.getNom(), "public");
		this.classeDest.ajoutAttribut(b);
		
		
	}
	
	public void toJava() {
		if(multipliciteIn == "1" && multipliciteOut == "1") {
			//unAun(this.getClasseDest().getNom(), this.getClasseDep().getNom());
		}
		else if(multipliciteIn == "1" && multipliciteOut == "n") {
			//unAn(this.getClasseDest().getNom(), this.getClasseDep().getNom());
		}
	}
	public void ajoutAssociation() {
		//this.getClasseDep().ajoutRelation(this);
	}
	
	

}
