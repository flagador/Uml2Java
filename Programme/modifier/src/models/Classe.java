package models;

import java.util.ArrayList;

public class Classe {

    private String nom;
    private ArrayList<Attribut> attributs;
    private ArrayList<Methode> methodes;
    private ArrayList<Relation> relations;

    public Classe() {
        attributs = new ArrayList<Attribut>();
        methodes = new ArrayList<Methode>();
        relations = new ArrayList<Relation>();
    }

    public Classe(String nom) {
        super();
        this.nom = nom;
        attributs = new ArrayList<Attribut>();
        methodes = new ArrayList<Methode>();
        relations = new ArrayList<Relation>();
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

    // M�thodes ajout

    public void ajoutAttribut(Attribut a) {

        attributs.add(a);

    }

    public void ajoutMethode(Methode m) {

        methodes.add(m);

    }

    public void ajoutRelation(Relation r) {

        relations.add(r);

    }

    // M�thode supprime

    public void suprAttribut(Attribut a) {

        attributs.remove(a);

    }

    public void suprMethode(Methode m) {

        methodes.remove(m);

    }

    public void suprRelation(Relation r) {

        relations.remove(r);

    }

    // trad

    public String traductionJava() {
        String trad = "";
        String entete = "";
        String constructeur = "";
        String attributsJava = "";
        String getSet = "";
        String methodes = "";

        entete += "Public class " + this.nom;
        for (int i = 0; i < this.relations.size(); i++) {
            System.out.println(this.getNom());
            if (this.relations.get(i).getType().equals("generalisation") && this.relations.get(i).getEnfant().getNom().equals(this.getNom())) {
                entete += this.relations.get(i).traductionDeclarationClasse();
            }
        }
        //entete de la classe fille ne fonctionne pas
        entete += " {\r\n";
        for (int i = 0; i < this.attributs.size(); i++) {
            attributsJava += this.getAttributs().get(i).toJava() + "\r\n";
        }
        constructeur = "Public " + this.nom + "(";

        for (int i = 1; i < this.attributs.size(); i++) {
            constructeur += ", " + this.attributs.get(i).getType() + " " + this.attributs.get(i).getNom();
        }
        constructeur += "){\r\n ";
        for (int i = 0; i < this.attributs.size(); i++) {
            constructeur += "this." + this.getAttributs().get(i).getNom() + " = " + this.getAttributs().get(i).getNom() + ";\r\n";
        }
        constructeur += "}\r\n";
        for (int i = 0; i < this.attributs.size(); i++) {
            if (this.attributs.get(i).getVisibilite() == Visibilite.PRIVATE) {
                getSet += this.attributs.get(i).getterSetter();
            }
        }
        for (int i = 0; i < this.methodes.size(); i++) {
            methodes += this.methodes.get(i).toJava();
        }
        trad += entete + attributsJava + constructeur + getSet + methodes;
        return trad;
    }
/*
    public static void main(String[] args) {
        Classe Voiture = new Classe("Voiture");
        Classe Porsche911GT3RS = new Classe("Porsche911GT3RS");
        Generalisation generalisation = new Generalisation("generalisation", Voiture, Porsche911GT3RS);
        Voiture.relations.add(generalisation);
        Methode puissanceFiscale = new Methode("puissanceFiscale", Visibilite.PUBLIC, Type.FLOAT, Voiture.attributs, "return this.puissanceMoteur/10;");
        Attribut Moteur = new Attribut("puissanceMoteur", Type.FLOAT, Visibilite.PRIVATE);
        Attribut Volant = new Attribut("couleur", Type.STRING, Visibilite.PRIVATE);
        Voiture.ajoutAttribut(Moteur);
        Voiture.ajoutAttribut(Volant);
        Voiture.ajoutMethode(puissanceFiscale);
        System.out.println(Voiture.traductionJava() + "}");
        System.out.println(Porsche911GT3RS.traductionJava() + "}");
    }*/
}