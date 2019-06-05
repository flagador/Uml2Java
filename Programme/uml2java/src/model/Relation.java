package model;

public abstract class Relation {
    private String type;

    /**
     * Represente une relation UML
     *
     * @param multiplicityIn
     * @param multiplicityOut
     * @param type
     * @param libelle
     */
    public Relation(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Classe getParent() {
    	Classe parent = null;
		return parent;
	}
    public Classe getEnfant() {
    	Classe enfant = null;
		return enfant;
	}
    public String traductionDeclarationClasse() {
    	String generalisation = "";
		return generalisation;
	}
    
    public String traductionAttributsConstructeur() {
    	String generalisation = "";
		return generalisation;
	}
    public String traductionSuperConstructeur() {
    	String generalisation = "";
		return generalisation;
	}
    public void toJava() {
    }

}
