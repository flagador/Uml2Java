package views;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.*;

public class FenetreAjouterMethode extends Stage {

    private Methode methode;

    private Label erreurLabel = new Label();

    private Label nomMethode = new Label("Nom : ");
    private Label typeMethode = new Label("Type : ");
    private Label visibiliteMethode = new Label("Visibilite : ");
    private Label parametresLabel = new Label("Parametres");

    private TextField textFieldNom = new TextField();
    private ComboBox<Type> comboBoxType = new ComboBox<>();
    private ComboBox<Visibilite> comboBoxVisibilite = new ComboBox<>();
    private ListView<Parametre> parametreListView = new ListView<>();

    private HBox hBoxNom = new HBox();
    private HBox hBoxTyoe = new HBox();
    private HBox hBoxVisibilite = new HBox();
    private VBox vBoxParametres = new VBox();
    private VBox vBox = new VBox();

    private Button ajouterParametre = new Button("+");
    private Button editParametre = new Button("E");
    private Button supprimerParametre = new Button("-");
    private ButtonBar parametreBar = new ButtonBar();

    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");
    private ButtonBar buttonBar = new ButtonBar();

    public FenetreAjouterMethode() {
        this.setTitle("Ajouter Methode");
        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setScene(new Scene(initControls()));
    }

    private Parent initControls() {
        VBox root = new VBox();
        root.setSpacing(20.0);
        root.setPadding(new Insets(10.0));

        buttonBar.setPadding(new Insets(0.0));
        buttonBar.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);

        comboBoxVisibilite.setItems(FXCollections.observableArrayList(Visibilite.values()));
        comboBoxType.setItems(FXCollections.observableArrayList(Type.values()));

        hBoxNom.getChildren().addAll(nomMethode, textFieldNom);
        hBoxNom.setSpacing(10.0);
        hBoxTyoe.getChildren().addAll(typeMethode, comboBoxType);
        hBoxTyoe.setSpacing(10.0);
        hBoxVisibilite.getChildren().addAll(visibiliteMethode, comboBoxVisibilite);
        hBoxVisibilite.setSpacing(10.0);
        vBox.getChildren().addAll(hBoxNom, hBoxTyoe, hBoxVisibilite);
        vBox.setSpacing(10.0);

        erreurLabel.setId("erreur");

        vBoxParametres.setSpacing(5.0);
        vBoxParametres.getChildren().addAll(parametresLabel, parametreListView, parametreBar);

        parametreBar.getButtons().addAll(ajouterParametre, editParametre, supprimerParametre);
        buttonBar.getButtons().addAll(confirmer, annuler);

        root.getChildren().addAll(vBox, vBoxParametres, erreurLabel, buttonBar);

        confirmer.setOnAction(event -> {
            creerMethode();
        });

        annuler.setOnAction(event -> {
            close();
        });

        ajouterParametre.setOnAction(event -> {
            FenetreAjouterParametre fenetreAjouterParametre = new FenetreAjouterParametre();
            fenetreAjouterParametre.showAndWait();
        });

        return root;
    }

    public Methode getMethode() {
        return methode;
    }

    private void creerMethode() {
        if (estValide()) {
            methode = new Methode();
            methode.setNom(textFieldNom.getText());
            methode.setVisibilite(comboBoxVisibilite.getValue());
            methode.setType(comboBoxType.getValue());
            close();
        }
    }

    private boolean estValide() {
        if (textFieldNom.getText() == null || textFieldNom.getText().isEmpty() || comboBoxVisibilite.getSelectionModel().getSelectedItem() == null
                || comboBoxType.getSelectionModel().getSelectedItem() == null) {
            erreurLabel.setText("Tous les champs doivent etre remplis");
            return false;
        }
        erreurLabel.setText("");
        return true;
    }
}
