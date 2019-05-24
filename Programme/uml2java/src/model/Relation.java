package model;

public abstract class Relation {
    private String type;

    /**
     * Represente une relation UML
     *
     * @param multiplicityIn
     * @param multiplicityOut
     * @param type
     * @param libelle
     */
    public Relation(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

}
