package model;

import java.util.ArrayList;

public class Classe {

    private String              nom;
    private ArrayList<Attribut> attributs;
    private ArrayList<Methode>  methodes;
    private ArrayList<Relation> relations;

    /**
     * Represente une classe UML
     *
     * @param nom
     * @param attributs
     * @param methodes
     * @param relations
     */
    public Classe(String nom) {
    	
        this.nom = nom;
        this.attributs = new ArrayList <Attribut> ();
        this.methodes = new ArrayList <Methode> ();
        this.relations = new ArrayList <Relation> ();
    }

    
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Attribut> getAttributs() {
		return attributs;
	}

	public void setAttributs(ArrayList<Attribut> attributs) {
		this.attributs = attributs;
	}

	public ArrayList<Methode> getMethodes() {
		return methodes;
	}

	public void setMethodes(ArrayList<Methode> methodes) {
		this.methodes = methodes;
	}

	public ArrayList<Relation> getRelations() {
		return relations;
	}

	public void setRelations(ArrayList<Relation> relations) {
		this.relations = relations;
	}
	
	
	// Méthodes ajout
	
	public void ajoutAttribut(Attribut a) {
		
		attributs.add(a);
		
	}
	
	
	public void ajoutMethode(Methode m) {
		
		methodes.add(m);
		
	}

}
