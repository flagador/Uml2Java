package creation_Classe;

public class RelationU2J {
	private String MultiplicityIn;
	private String MultiplicityOut;
	private String type;
	private String libelle;
	
	public RelationU2J(String multiplicityIn, String multiplicityOut, String type, String libelle) {
		super();
		MultiplicityIn = multiplicityIn;
		MultiplicityOut = multiplicityOut;
		this.type = type;
		this.libelle = libelle;
	}

	public String getMultiplicityIn() {
		return MultiplicityIn;
	}

	public void setMultiplicityIn(String multiplicityIn) {
		MultiplicityIn = multiplicityIn;
	}

	public String getMultiplicityOut() {
		return MultiplicityOut;
	}

	public void setMultiplicityOut(String multiplicityOut) {
		MultiplicityOut = multiplicityOut;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
