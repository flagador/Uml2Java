package models;

public enum Type {
    VOID("void"),
    BOOLEAN("boolean"),
    CHAR("char"),
    STRING("string"),
    // Entier
    BYTE("byte"),
    SHORT("short"),
    INT("int"),
    LONG("long"),
    // FLottant
    FLOAT("float"),
    DOUBLE("double");

    private String nom;

    Type(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
