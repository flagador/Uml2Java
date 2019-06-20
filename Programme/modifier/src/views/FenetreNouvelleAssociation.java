package views;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Association;
import models.Attribut;
import models.Classe;
import models.Methode;

public class FenetreNouvelleAssociation extends Stage {

	private Association association;

    private Label erreurLabel = new Label();

    private HBox hBoxNomAssociation = new HBox();
    private Label nomAssociationLabel = new Label("Nom de la classe :");
    private TextField nomAssociationTextArea = new TextField();

    private Label classe1Label = new Label("Classe 1 :");
    private ComboBox<Classe> classe1 = new ComboBox();
    

    private Label classe2Label = new Label("Classe 2 :");
    private ComboBox<Classe> classe2 = new ComboBox();
    
    private ButtonBar buttonBar = new ButtonBar();
    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");

    public FenetreNouvelleAssociation() {
        this.setTitle("Nouvelle classe");
        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);

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

    public Association getAssociation() {
        return this.association;
    }

    /**
     * Creer une nouvelle association
     */
    private void creerAssociation() {
        if (estValide()) {
            association = new Association(classe1.getSelectionModel().getSelectedItem(), classe2.getSelectionModel().getSelectedItem(), "Association", "af", "af", nomAssociationTextArea.getText());
            association.setNom(nomAssociationTextArea.getText());
            for (Attribut attribut : attributsList.getItems())
                classe.getAttributs().add(attribut);
            for (Methode methode : methodesList.getItems())
                classe.getMethodes().add(methode);
            this.close();
        }
    }

    /**
     * Teste la validite des info
     *
     * @return true si valide
     */
    private boolean estValide() {
        if (nomClasseTextArea.getText() == null || nomClasseTextArea.getText().isEmpty()) {
            erreurLabel.setText("Le nom de classe est obligatoire");
            return false;
        }
        if (!Character.isUpperCase(nomClasseTextArea.getText().charAt(0))) {
            erreurLabel.setText("La premiere lettre doit etre une majuscule.");
            return false;
        }
        erreurLabel.setText("");
        return true;
    }

    private void ajouterAttribut() {
        FenetreAjouterAttribut fenetreAjouterAttribut = new FenetreAjouterAttribut();
        fenetreAjouterAttribut.showAndWait();
        if (fenetreAjouterAttribut.getAttribut() == null) return;
        attributsList.getItems().add(fenetreAjouterAttribut.getAttribut());
    }

    private void modifierAttribut() {
        if (getSelectedAttribut() == null) return;
        FenetreModifierAttribut fenetreModifierAttribut = new FenetreModifierAttribut(getSelectedAttribut());
        fenetreModifierAttribut.showAndWait();
        Attribut temp = fenetreModifierAttribut.getAttribut();
        getSelectedAttribut().setNom(temp.getNom());
        getSelectedAttribut().setType(temp.getType());
        getSelectedAttribut().setVisibilite(temp.getVisibilite());
        attributsList.refresh();
    }

    private void supprimerAttribut() {
        if (getSelectedAttribut() == null) return;
        attributsList.getItems().remove(attributsList.getSelectionModel().getSelectedIndex());
    }

    private void ajouterMethode() {
        FenetreAjouterMethode fenetreAjouterMethode = new FenetreAjouterMethode();
        fenetreAjouterMethode.showAndWait();
        if (fenetreAjouterMethode.getMethode() == null) return;
        methodesList.getItems().add(fenetreAjouterMethode.getMethode());
    }

    private void modifierMethode() {

    }

    private void supprimerMethode() {
        if (getSelectedMethode() == null) return;
        methodesList.getItems().remove(methodesList.getSelectionModel().getSelectedIndex());
    }
	
}
