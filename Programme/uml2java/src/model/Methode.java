package model;

import java.util.ArrayList;

public class Methode {

    private String nom;
    private String visibilite;
    private String type;
    private ArrayList<Attribut> attributs;
    private String contenuMethode;

	/**
     * Represente une Methode UML
     *
     * @param nom
     * @param visibilite
     * @param type
     * @param variables
     */
    public Methode(String nom, String visibilite, String type, ArrayList<Attribut> attributs, String contenuMethode) {
        this.nom = nom;
        this.visibilite = visibilite;
        this.type = type;
        this.attributs = attributs;
        this.contenuMethode = contenuMethode;
    }

	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public ArrayList<Attribut> getAttributs() {
		return attributs;
	}

	public void setAttributs(ArrayList<Attribut> attributs) {
		this.attributs = attributs;
	}
    public String getContenuMethode() {
		return contenuMethode;
	}

	public void setContenuMethode(String contenuMethode) {
		this.contenuMethode = contenuMethode;
	}
	
    public String toJava() {
    	String trad = "";
    	trad+=this.visibilite+" "+this.type+" "+this.nom+"(";
    	if (this.attributs.size()<=1) {
    		trad+=this.attributs.get(0).getType()+" "+this.attributs.get(0).getNom();
    	}
    	else {
    		trad+=this.attributs.get(0).getType()+" "+this.attributs.get(1).getNom();
        	for (int i=1; i<this.attributs.size();i++) {
        		trad+=", "+this.attributs.get(i).getType()+" "+this.attributs.get(i).getNom();
        	}
    	}
    	trad+=") {\r\n";
    	trad+=this.contenuMethode;
    	trad+="\r\n}\r\n";
    	return trad;
    }

}
