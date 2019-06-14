package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Attribut;

public class FenetreMethode extends Stage {

	private model.Methode methode;
	private FenetreNouvelleClasse fenetreNouvelleClasse;
	
    private Label nommethode = new Label("Nom : ");
    private Label typemethode = new Label("Type : ");
    private Label visibilitemethode = new Label("Visibilite : ");
    private Label parametremethode = new Label("Parametre : ");

    private TextField textFieldNom = new TextField();
    private ComboBox<String> comboBoxType = new ComboBox<>();
    private ComboBox<String> comboBoxVisibilite = new ComboBox<>();
    private ComboBox<model.Attribut> comboBoxAttribut = new ComboBox<>();
    

    private Button parametre = new Button("Nouveau");
    private ListView<Attribut> parametreList = new ListView<Attribut>();
    ObservableList <Attribut> items;
    
    private HBox nom = new HBox();
    private HBox type = new HBox();
    private HBox visibilite = new HBox();
    private HBox attribut = new HBox();
    private VBox corps = new VBox();
    private ButtonBar boutons = new ButtonBar();

    private String[] visibilites = {"public", "private", "protected"};
    private String[] types = {"float", "boolean", "String", "int", "double", "void"};
    private model.Attribut[] parametres = new model.Attribut[20];
    		
    private Button confirmer = new Button("Confirmer");
    private Button annuler   = new Button("Annuler");
    
    public FenetreMethode(FenetreNouvelleClasse f) {
    	this.fenetreNouvelleClasse = f;
    	this.methode = new model.Methode();
    	this.setTitle("Methode");

        Scene scene = new Scene(init());
        this.setScene(scene);
        initEvents();
    }
    
    
    public model.Methode getMethode() {
		return methode;
	}


	public void setMethode(model.Methode methode) {
		this.methode = methode;
	}
	
	public ListView<Attribut> getParametreList() {
		return parametreList;
	}

	public void setParametreList(ListView<Attribut> parametreList) {
		this.parametreList = parametreList;
	}


	private Parent init() {
        VBox root = new VBox();

        root.setPadding(new Insets(5));
        nom.setPadding(new Insets(2.5));
        type.setPadding(new Insets(2.5));
        visibilite.setPadding(new Insets(2.5));
        attribut.setPadding(new Insets(2.5));
        boutons.setPadding(new Insets(10));
        
        int i = 0;
        
        for(i = 0; i < fenetreNouvelleClasse.getAttributsList().getItems().size(); i++) {
        	
			parametres[i] = fenetreNouvelleClasse.getAttributsList().getItems().get(i);
			
		}
        
        
        comboBoxType.getItems().addAll(types);
        comboBoxVisibilite.getItems().addAll(visibilites);
        comboBoxAttribut.getItems().addAll(parametres);

        nom.getChildren().addAll(nommethode, textFieldNom);
        type.getChildren().addAll(typemethode, comboBoxType);
        visibilite.getChildren().addAll(visibilitemethode, comboBoxVisibilite);
        attribut.getChildren().addAll(parametremethode, comboBoxAttribut, parametre);

        corps.getChildren().addAll(nom, type, visibilite, attribut);
        
        boutons.getButtons().addAll(confirmer, annuler);
        
        root.getChildren().addAll(corps, boutons);

        return root;
    }
	
	 private void initEvents() {
	    	
		 	parametre.setOnAction(event -> {
		 		newAttribut();
		 	});
		 
	    	annuler.setOnAction(event -> {
	            annulermethode();
	        });
	    	
	    	confirmer.setOnAction(event -> {
	    		ajoutermethode();
	    	});
	    	
	    }
	    
	 
	 	public void newAttribut() {
	 		
	 		FenetreParametre fenetreParametre = new FenetreParametre(this);
            
            fenetreParametre.show();
	 		
	 	}
	 
	    
	    public void annulermethode() {
	    	
	    	close();
	    	
	    }
	    
	    
	    public void ajoutermethode() {
	        if (estValide()) {
	        	
	        	methode.setNom(textFieldNom.getText());
	        	methode.setVisibilite(comboBoxVisibilite.getValue());
	        	methode.setType(comboBoxType.getValue());
	        	//methode.setAttributs(comboBoxAttribut.getValue());
	        	
	        	fenetreNouvelleClasse.itemsM = FXCollections.observableArrayList(methode);
	            
	        	fenetreNouvelleClasse.getMethodesList().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	        	
	        	fenetreNouvelleClasse.getMethodesList().getItems().add(methode);
	            
	            close();
	        }

	    }
	    
	    
	    private boolean estValide() {
	        if (textFieldNom.getText() == null || textFieldNom.getText().isEmpty()) {
	            return false;
	        }

	        return true;
	    }
}
