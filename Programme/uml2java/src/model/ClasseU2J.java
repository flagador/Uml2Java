package model;

import java.util.ArrayList;

public class ClasseU2J {

	private String nom;
	private ArrayList<AttributU2J> attributs;
	private ArrayList<MethodeU2J> methodes;
	private ArrayList<RelationU2J> relations;
	
	public ClasseU2J(String nom, ArrayList<AttributU2J> attributs, ArrayList<MethodeU2J> methodes,
			ArrayList<RelationU2J> relations) {
		super();
		this.nom = nom;
		this.attributs = attributs;
		this.methodes = methodes;
		this.relations = relations;
	}
	
	
	
	
}
