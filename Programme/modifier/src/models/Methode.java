package models;

import java.util.ArrayList;

public class Methode {

    private String nom;
    private Visibilite visibilite;
    private Type type;
    private ArrayList<Parametre> parametres;
    private String contenuMethode;

    public Methode() {
        parametres = new ArrayList<>();
    }

	/**
     * Represente une Methode UML
     *
     * @param nom
     * @param visibilite
     * @param type
     */
    public Methode(String nom, Visibilite visibilite, Type type, ArrayList<Parametre> parametres, String contenuMethode) {
        this.nom = nom;
        this.visibilite = visibilite;
        this.type = type;
        this.parametres = parametres;
        this.contenuMethode = contenuMethode;
    }

	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Visibilite getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(Visibilite visibilite) {
        this.visibilite = visibilite;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ArrayList<Parametre> getParametres() {
		return parametres;
	}

	public void setParametres(ArrayList<Parametre> parametres) {
		this.parametres = parametres;
	}
    public String getContenuMethode() {
		return contenuMethode;
	}

	public void setContenuMethode(String contenuMethode) {
		this.contenuMethode = contenuMethode;
	}
	/*
    public String toJava() {
    	String trad = "";

    	trad+=this.visibilite+" "+this.type+" "+this.nom+"(";
    	if (this.parametres.size()<=1) {
    		trad+=this.parametres.get(0).getType()+" "+this.parametres.get(0).getNom();
    	}
    	else {
    		trad+=this.parametres.get(0).getType()+" "+this.parametres.get(1).getNom();
        	for (int i=1; i<this.parametres.size();i++) {
        		trad+=", "+this.parametres.get(i).getType()+" "+this.parametres.get(i).getNom();
        	}
    	}
    	trad+=") {\r\n";
    	trad+=this.contenuMethode;
    	trad+="\r\n}\r\n";
    	return trad;
    }
*/
	public String toJava() {
        String trad = "";
        trad += visibilite.getNom() + " " + type.getNom() + " " + nom + "(";
        for (Parametre parametre : parametres) {
            trad += parametre.toJava() + ",";
        }
        if (!parametres.isEmpty())
            trad = trad.substring(0, trad.length() - 1);
        trad += ") {\n}";
        return trad;
    }

    public String toString() {
        return toJava();
    }

}
