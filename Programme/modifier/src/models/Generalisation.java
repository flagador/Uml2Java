package models;

public class Generalisation extends Relation {

	private Classe parent;
	private Classe enfant;
	
	public Generalisation(String type, Classe parent, Classe enfant) {
		super(type);
		this.parent = parent;
		this.enfant = enfant;
	}

	public Classe getParent() {
		return parent;
	}

	public void setParent(Classe parent) {
		this.parent = parent;
	}

	public Classe getEnfant() {
		return enfant;
	}

	public void setEnfant(Classe enfant) {
		this.enfant = enfant;
	}
	
	public String traductionDeclarationClasse() {
		String generalisation = "";
		generalisation += " extends "+this.parent.getNom();
		return generalisation;
	}
	
	public String traductionSuperConstructeur() {
		
		String generalisation = "";
		
		generalisation += "super(";
		generalisation += this.parent.getAttributs().get(0).getNom();
        for (int i = 1; i < this.parent.getAttributs().size(); i++) { 
        	generalisation += ", " +this.parent.getAttributs().get(i).getNom();
        }
        generalisation+=");\r\n";
		return generalisation;
	}
	
	public String traductionAttributsConstructeur() {
		String generalisation = "";
	 		generalisation += this.parent.getAttributs().get(0).getType() + " " + this.parent.getAttributs().get(0).getNom();
        for (int i = 1; i < this.parent.getAttributs().size(); i++) { 
        	generalisation += ", " + this.parent.getAttributs().get(i).getType() + " " + this.parent.getAttributs().get(i).getNom();
        }
		return generalisation;
	}

	
	
	
	
	
}
