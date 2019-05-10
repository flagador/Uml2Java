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
    public Classe(String nom, ArrayList<Attribut> attributs, ArrayList<Methode> methodes, ArrayList<Relation> relations) {
        super();
        this.nom = nom;
        this.attributs = attributs;
        this.methodes = methodes;
        this.relations = relations;
    }

}
