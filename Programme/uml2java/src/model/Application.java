package model;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static Application APP = new Application();
	private List<Classe> classes;
	private List<Association> associations;
	
	
	private Application() {
		this.classes = new ArrayList<>();
		this.associations = new ArrayList<>(); 
	}
	
	public void ajoutAssociation(Association a){
		associations.add(a);
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
}
