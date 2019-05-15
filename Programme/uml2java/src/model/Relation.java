package model;

public abstract class Relation {
    private String type;
    private String libelle;

    /**
     * Represente une relation UML
     *
     * @param multiplicityIn
     * @param multiplicityOut
     * @param type
     * @param libelle
     */
    public Relation(String type, String libelle) {
        this.type = type;
        this.libelle = libelle;
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
