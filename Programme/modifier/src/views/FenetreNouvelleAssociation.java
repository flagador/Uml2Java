package views;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import models.Association;
import models.Attribut;
import models.Classe;
import models.Methode;


public class FenetreNouvelleAssociation extends Stage {

	private models.Association association;
	private FenetrePrincipal uml;
	
	private models.Classe[] comboClasse = new models.Classe[20];
	
    private Label erreurLabel = new Label();

    private HBox hBoxNomAssociation = new HBox();
    private Label nomAssociationLabel = new Label("Nom de la classe :");
    private TextField nomAssociationTextArea = new TextField();

    private Label classe1Label = new Label("Classe 1 :");
    private ComboBox<models.Classe> classe1 = new ComboBox();
    

    private Label classe2Label = new Label("Classe 2 :");
    private ComboBox<models.Classe> classe2 = new ComboBox();
    
    private ButtonBar buttonBar = new ButtonBar();
    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");

    public FenetreNouvelleAssociation(FenetrePrincipal f) {
        this.setTitle("Nouvelle classe");
        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);
        this.uml = f;
        this.setScene(new Scene(initControls()));
        this.sizeToScene();
        initEvents();
    }

    private Parent initControls() {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        
        Font police = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 12);
        Font police2 = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 10);
        nomAssociationLabel.setFont(police);
        classe1Label.setFont(police);
        classe2Label.setFont(police);
        annuler.setFont(police);
        confirmer.setFont(police);
        erreurLabel.setFont(police);
        
        annuler.getStyleClass().add("annuler");

        buttonBar.getButtons().addAll(confirmer, annuler);

        int i = 0;
        
        for(i = 0; i < uml.getClasseList().getItems().size(); i++) {
        	
			comboClasse[i] = uml.getClasseList().getItems().get(i);
			
		}
        
        classe1.getItems().addAll(comboClasse);
        classe2.getItems().addAll(comboClasse);
        
        classe1.setPrefWidth(150);
        classe2.setPrefWidth(150);
        
        hBoxNomAssociation.getChildren().addAll(nomAssociationLabel, nomAssociationTextArea);
        hBoxNomAssociation.setSpacing(10);
        root.add(hBoxNomAssociation, 0, 0);
        root.add(buttonBar, 1, 4);

        // Attributs
        root.add(classe1Label, 0, 1);
        root.add(classe1, 0, 2);

        // Methodes
        root.add(classe2Label, 1, 1);
        root.add(classe2, 1, 2);

        // Erreur
        erreurLabel.setId("erreur");
        root.add(erreurLabel, 1, 0);

        return root;
    }

    private void initEvents() {
        confirmer.setOnAction(event -> {
            creerAssociation();
        });
        annuler.setOnAction(event -> {
            close();
        });
    }

    public models.Association getAssociation() {
        return this.association;
    }

    /**
     * Creer une nouvelle association
     */
    private void creerAssociation() {
        if (estValide()) {
        	
        	models.Classe c1, c2;

        	c1 = new models.Classe();
        	c2 = new models.Classe();

        	
        	c1 = classe1.getSelectionModel().getSelectedItem();
        	c2 = classe2.getSelectionModel().getSelectedItem();
        	
        	String lib = new String();
        	lib = nomAssociationTextArea.getText();
        	
            association = new models.Association(c1, c2, "Association", "af", "af", lib);
            association.setLibelle(nomAssociationTextArea.getText());
            for (models.Classe classe : classe1.getItems())
                classe.ajoutRelation(association);
            for (models.Classe classe2 : classe2.getItems())
                classe2.ajoutRelation(association);
            this.close();
        }
    }

    /**
     * Teste la validite des info
     *
     * @return true si valide
     */
    private boolean estValide() {
        if (classe1 == null || classe2 == null) {
            erreurLabel.setText("Les classes sont obligatoires");
            return false;
        }
        erreurLabel.setText("");
        return true;
    }
    
}
