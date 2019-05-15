package model;

public class Generalisation extends Relation {

	private Classe parent;
	private Classe enfant;
	
	public Generalisation(String type, Classe parent, Classe enfant) {
		super(type);
		this.parent = parent;
		this.enfant = enfant;
		// TODO Auto-generated constructor stub
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

	
	
	
	
	
}
