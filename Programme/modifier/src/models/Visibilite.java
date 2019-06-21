package models;

public enum Visibilite {
    PRIVATE("private"),
    PROTECTED("protected"),
    PUBLIC("public"),
    NO_MODIFIER("");

    private String nom;

    Visibilite(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
