package models;

public class Attribut {

    private String nom;
    private Type type;
    private Visibilite visibilite;

    public Attribut() {
        super();
    }

    /**
     * Represent un attribut d'une classe UML
     *
     * @param nom
     * @param type
     * @param visibilite
     */
    public Attribut(String nom, Type type, Visibilite visibilite) {
        super();
        this.nom = nom;
        this.type = type;
        this.visibilite = visibilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Visibilite getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(Visibilite visibilite) {
        this.visibilite = visibilite;
    }
    
    public String toJava() {
    	return toJava();
    }

    public String toString() { return getVisibilite().getNom() +" "+ getType().getNom() +" " +getNom(); }
    
    public String getterSetter() {
    	String getset ="";
    	getset+= "public "+getType()+" get"+getNom()+"() {\r\n	return "+getNom().toLowerCase()+";\r\n}\r\n";
    	getset+= "public void set"+getNom()+"("+getType()+" "+getNom().toLowerCase()+") {\r\n	this."+getNom().toLowerCase()+" = "+getNom().toLowerCase()+";\r\n}\r\n";
    	return getset;
    }
}
