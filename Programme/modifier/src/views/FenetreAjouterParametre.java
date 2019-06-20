package views;

import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Type;

public class FenetreAjouterParametre extends Stage {

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

    private Parent initControls() {
        VBox root = new VBox();
        root.setSpacing(10.0);

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

    private void creerParametre() {
        if (estValide()) {

        }
    }

    private boolean estValide() {
        if (nomTextField.getText() == null || nomTextField.getText().isEmpty() || typeComboBox.getValue() == null
                || typeComboBox.getSelectionModel().getSelectedItem() == null) {
            erreurLabel.setText("");
        }
        return true;
    }
}
