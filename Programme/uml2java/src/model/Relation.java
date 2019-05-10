package model;

public class Relation {
    private String MultiplicityIn;
    private String MultiplicityOut;
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
    public Relation(String multiplicityIn, String multiplicityOut, String type, String libelle) {
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
