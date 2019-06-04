package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreAttribut extends Stage {
	
	private model.Attribut attribut;
	private FenetreNouvelleClasse fenetreNouvelleClasse;
	
    private Label nomAttribut        = new Label("Nom : ");
    private Label typeAttribut       = new Label("Type : ");
    private Label visibiliteAttribut = new Label("Visibilite : ");

    private TextField        textFieldNom       = new TextField();
    private ComboBox<String> comboBoxType       = new ComboBox<>();
    private ComboBox<String> comboBoxVisibilite = new ComboBox<>();

    private HBox nom = new HBox();
    private HBox type = new HBox();
    private HBox visibilite = new HBox();
    private VBox corps = new VBox();
    private ButtonBar boutons = new ButtonBar();

    private String[] visibilites = {"public", "private", "protected"};
    private String[] types = {"float", "boolean", "String", "int", "double", ""};
    
    private Button confirmer = new Button("Confirmer");
    private Button annuler   = new Button("Annuler");

    public FenetreAttribut(FenetreNouvelleClasse f) {
    	this.fenetreNouvelleClasse = f;
    	this.attribut = new model.Attribut();
        this.setTitle("Attribut");

        Scene scene = new Scene(init());
        this.setScene(scene);
        initEvents();
    }
    

    public model.Attribut getAttribut() {
		return attribut;
	}


	public void setAttribut(model.Attribut attribut) {
		this.attribut = attribut;
	}


	private Parent init() {
    	
        VBox root = new VBox();
        
        annuler.setId("annuler");
        
        root.setPadding(new Insets(5));
        nom.setPadding(new Insets(2.5));
        type.setPadding(new Insets(2.5));
        visibilite.setPadding(new Insets(2.5));
        boutons.setPadding(new Insets(10));
        
        comboBoxType.getItems().addAll(types);
        comboBoxVisibilite.getItems().addAll(visibilites);

        nom.getChildren().addAll(nomAttribut, textFieldNom);
        type.getChildren().addAll(typeAttribut, comboBoxType);
        visibilite.getChildren().addAll(visibiliteAttribut, comboBoxVisibilite);

        corps.getChildren().addAll(nom, type, visibilite);
        
        boutons.getButtons().addAll(confirmer, annuler);
        
        root.getChildren().addAll(corps, boutons);

        return root;
    }
    
    private void initEvents() {
    	
    	annuler.setOnAction(event -> {
            annulerAttribut();
        });
    	
    	confirmer.setOnAction(event -> {
    		ajouterAttribut();
    	});
    	
    }
    
    
    private void annulerAttribut() {
    	
    	close();
    	
    }
    
    
    private void ajouterAttribut() {
        if (estValide()) {
        	
        	attribut.setNom(textFieldNom.getText());
        	attribut.setVisibilite(comboBoxVisibilite.getValue());
        	attribut.setType(comboBoxType.getValue());
        	
        	fenetreNouvelleClasse.items = FXCollections.observableArrayList(attribut);
            
        	fenetreNouvelleClasse.getAttributsList().getSelectionModel().getSelectedItem();
        	
        	fenetreNouvelleClasse.getAttributsList().getItems().add(attribut);
            
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
