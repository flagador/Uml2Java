package view;

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

    private VBox labels  = new VBox();
    private VBox valeurs = new VBox();

    private String[] visibilites = {"public", "private", "protected"};
    private String[] types = {"float", "boolean", "String", "int", "double", ""};

    public FenetreAttribut() {
        this.setTitle("Attribut");

        Scene scene = new Scene(init());
        this.setScene(scene);
    }

    private Parent init() {
        HBox root = new HBox();

        comboBoxType.getItems().addAll(types);
        comboBoxVisibilite.getItems().addAll(visibilites);

        labels.getChildren().addAll(nomAttribut, typeAttribut, visibiliteAttribut);
        valeurs.getChildren().addAll(textFieldNom, comboBoxType, comboBoxVisibilite);

        root.getChildren().addAll(labels, valeurs);

        root.getChildren().add(root);
        return root;
    }
}
