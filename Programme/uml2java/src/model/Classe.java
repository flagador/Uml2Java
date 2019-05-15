package model;

import java.util.ArrayList;

public class Classe {

    private String              nom;
    private ArrayList<Attribut> attributs;
    private ArrayList<Methode>  methodes;
    private ArrayList<Relation> relations;
    
    private ArrayList<ClassProperty> properties;
    
    public Classe(String nom) {
        super();
        this.nom = nom;
        attributs = new ArrayList<Attribut>();
        methodes = new ArrayList<Methode>();
        relations = new ArrayList<Relation>();
    }
    
	/**
     * Represente une classe UML
     *
     * @param nom
     * @param attributs
     * @param methodes
     * @param relations
     */
    

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



	public String traductionJava() {
		String trad;
		String entete = "";
		String attributsJava = "";
		
	/*	for (int i = 0; i < properties.size(); i++) {
			if(properties.get(i) == ClassProperty.ABSTRACT)
				entete += ClassProperty.ABSTRACT.javaText();
		} */
		 entete += " class "+this.nom+" {\\r\\n";
		for (int i = 0; i < this.attributs.size(); i++) {
			attributsJava += this.attributs.get(i).getVisibilite() +" "+ this.attributs.get(i).getNom();
		}
		return 0;
	}

}