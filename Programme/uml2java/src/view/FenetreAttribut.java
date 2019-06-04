package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreAttribut extends Stage {

    private Label nomAttribut        = new Label("Nom :");
    private Label typeAttribut       = new Label("Type :");
    private Label visibiliteAttribut = new Label("Visibilite");

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

    public FenetreAttribut() {
        this.setTitle("Attribut");

        Scene scene = new Scene(init());
        this.setScene(scene);
        initEvents();
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
    	
    }
    
    
    private void annulerAttribut() {
    	
    	close();
    	
    }
}
