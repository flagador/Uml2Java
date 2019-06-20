package views;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Parametre;
import models.Type;

public class FenetreAjouterParametre extends Stage {

    private Parametre parametre;

    private Label nomLabel = new Label("Nom : ");
    private Label typeLabel = new Label("Type : ");
    private Label erreurLabel = new Label();
    private TextField nomTextField = new TextField();
    private ComboBox<Type> typeComboBox = new ComboBox<>();

    private HBox nomBox = new HBox();
    private HBox typeBox = new HBox();

    private ButtonBar buttonBar = new ButtonBar();
    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");

    public FenetreAjouterParametre() {
        this.setTitle("Ajouter Parametre");
        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);

        this.setScene(new Scene(initControls()));

    }

    /**
     * Initialize le contenu de la fenetre
     *
     * @return le contenu
     */
    private Parent initControls() {
        VBox root = new VBox();
        root.setSpacing(10.0);
        root.setPadding(new Insets(10.0));

        erreurLabel.setId("erreur");
        annuler.setId("annuler");

        Font police = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 12);
        annuler.setFont(police);
        confirmer.setFont(police);    
        nomLabel.setFont(police);
        typeLabel.setFont(police);
        erreurLabel.setFont(police);
        
        annuler.getStyleClass().add("annuler");
        
        typeComboBox.setItems(FXCollections.observableArrayList(Type.values()));

        nomBox.getChildren().addAll(nomLabel, nomTextField);
        typeBox.getChildren().addAll(typeLabel, typeComboBox);

        buttonBar.getButtons().addAll(confirmer, annuler);

        root.getChildren().addAll(nomBox, typeBox, erreurLabel, buttonBar);

        confirmer.setOnAction(event -> {
            creerParametre();
        });
        annuler.setOnAction(event -> {
            close();
        });
        return root;
    }

    /**
     * Gets parametre.
     *
     * @return the parametre
     */
    public Parametre getParametre() {
        return parametre;
    }

    /**
     * Permet la creation d'un nouveau parametre
     */
    private void creerParametre() {
        if (estValide()) {
            parametre = new Parametre();
            parametre.setNom(nomTextField.getText());
            parametre.setType(typeComboBox.getValue());
            close();
        }
    }

    /**
     * Verifie la validite des entrees
     *
     * @return true si correct. false sinon
     */
    private boolean estValide() {
        if (nomTextField.getText() == null || nomTextField.getText().isEmpty() || typeComboBox.getValue() == null
                || typeComboBox.getSelectionModel().getSelectedItem() == null) {
            erreurLabel.setText("Tous les champs doivent \n etre remplis");
        }
        return true;
    }
}
