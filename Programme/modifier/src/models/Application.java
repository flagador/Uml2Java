package models;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static Application APP = new Application();
	private List<Classe> classes;
	private List<Association> associations;
	private List<Generalisation> generalisations;
	
	
	private Application() {
		this.classes = new ArrayList<>();
		this.associations = new ArrayList<>(); 
		this.generalisations = new ArrayList<>();
	}
	
	public void ajoutAssociation(Association a){
		associations.add(a);
	}
	
	public void ajoutGeneralisation(Generalisation g) {
		generalisations.add(g);
		
	}
	
	public void ajoutClasse(Classe c){
		classes.add(c);
	}
	
	public List<Classe> getClasses(){
		return this.classes;
	}
	public List<Association> trouverAssociations(Classe c){
		List<Association> res = new ArrayList<>();
		
		associations.forEach(a -> {
			if(a.getClasseDep().equals(c)) {
				res.add(a);
			}
			
		});
		return res;
	}
	public List<Generalisation> trouverGeneralisations(Classe c){
		List<Generalisation> res = new ArrayList<>();
		
		generalisations.forEach(g -> {
			if(g.getEnfant().equals(c)) {
				res.add(g);
			}
			
		});
		return res;
	}
	


}
