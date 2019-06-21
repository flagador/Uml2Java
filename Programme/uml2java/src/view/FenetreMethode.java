package view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Attribut;
import model.Classe;
import model.Methode;

import java.util.ArrayList;
import java.util.List;

public class FenetreMethode extends Stage {

	private model.Methode methode;
	private Classe classe;
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
    
    public FenetreMethode(FenetreNouvelleClasse f, Classe c) {
    	this.fenetreNouvelleClasse = f;
    	this.classe = c;
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

        Font police = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 12);
        Font police2 = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 10);
        nommethode.setFont(police);
        typemethode.setFont(police);
        visibilitemethode.setFont(police);
        parametremethode.setFont(police);
        annuler.setFont(police2);
        confirmer.setFont(police2);
        parametre.setFont(police2);
        
        annuler.getStyleClass().add("annuler");
        
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
	 		
	 		FenetreParametre fenetreParametre = new FenetreParametre(this, methode);
            
            fenetreParametre.show();
	 		
	 	}
	 
	    
	    public void annulermethode() {
	    	
	    	close();
	    	
	    }
	    
	    
	    public void ajoutermethode() {
			ArrayList<Attribut> atts = new ArrayList();

	        if (estValide()) {
	        	
//	        	methode.setNom(textFieldNom.getText());
//	        	methode.setVisibilite(comboBoxVisibilite.getValue());
//	        	methode.setType(comboBoxType.getValue());
	        	//methode.setAttributs(comboBoxAttribut.getValue());
	        	
	        	methode = new Methode(textFieldNom.getText(),comboBoxVisibilite.getValue(),comboBoxType.getValue(),atts,"");
	        	
	        	fenetreNouvelleClasse.itemsM = FXCollections.observableArrayList(methode);
	            
	        	fenetreNouvelleClasse.getMethodesList().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	        	
	        	fenetreNouvelleClasse.getMethodesList().getItems().add(methode);
	            
	            close();
	        }

	    }
	    
	    
	    public TextField getTextFieldNom() {
			return textFieldNom;
		}


		public void setTextFieldNom(TextField textFieldNom) {
			this.textFieldNom = textFieldNom;
		}


		public ComboBox<String> getComboBoxType() {
			return comboBoxType;
		}


		public void setComboBoxType(ComboBox<String> comboBoxType) {
			this.comboBoxType = comboBoxType;
		}


		public ComboBox<String> getComboBoxVisibilite() {
			return comboBoxVisibilite;
		}


		public void setComboBoxVisibilite(ComboBox<String> comboBoxVisibilite) {
			this.comboBoxVisibilite = comboBoxVisibilite;
		}


		public ComboBox<model.Attribut> getComboBoxAttribut() {
			return comboBoxAttribut;
		}


		public void setComboBoxAttribut(ComboBox<model.Attribut> comboBoxAttribut) {
			this.comboBoxAttribut = comboBoxAttribut;
		}


		private boolean estValide() {
	        if (textFieldNom.getText() == null || textFieldNom.getText().isEmpty()) {
	            return false;
	        }

	        return true;
	    }
}
