package models;

public class Parametre {

    private Type type;
    private String nom;

    public Parametre() {

    }

    public Parametre(String nom, Type type) {
        this.nom = nom;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }
}
