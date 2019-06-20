package views;

import javafx.beans.binding.Bindings;
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
import models.Methode;
import models.Parametre;
import models.Type;
import models.Visibilite;

import java.util.ArrayList;

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
    private Button modifierParametre = new Button("E");
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

    /**
     * Initialize le contenu de la fenetre
     *
     * @return le contenu
     */
    private Parent initControls() {
        VBox root = new VBox();
        root.setSpacing(20.0);
        root.setPadding(new Insets(10.0));

        buttonBar.setPadding(new Insets(0.0));
        buttonBar.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        
        Font police = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 12);
        nomMethode.setFont(police);
        typeMethode.setFont(police);
        ajouterParametre.setFont(police);
        parametresLabel.setFont(police);
        supprimerParametre.setFont(police);
        visibiliteMethode.setFont(police);
        annuler.setFont(police);
        confirmer.setFont(police);
        
        annuler.getStyleClass().add("annuler");

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
        annuler.setId("annuler");

        vBoxParametres.setSpacing(5.0);
        vBoxParametres.getChildren().addAll(parametresLabel, parametreListView, parametreBar);

        parametreBar.getButtons().addAll(ajouterParametre, modifierParametre, supprimerParametre);
        buttonBar.getButtons().addAll(confirmer, annuler);

        root.getChildren().addAll(vBox, vBoxParametres, erreurLabel, buttonBar);

        modifierParametre.disableProperty().bind(Bindings.isEmpty(parametreListView.getSelectionModel().getSelectedItems()));
        supprimerParametre.disableProperty().bind(Bindings.isEmpty(parametreListView.getSelectionModel().getSelectedItems()));

        confirmer.setOnAction(event -> {
            creerMethode();
        });

        annuler.setOnAction(event -> {
            close();
        });

        ajouterParametre.setOnAction(event -> {
            ajouterParametre();
        });

        modifierParametre.setOnAction(event -> {
            modifierParametre();
        });

        supprimerParametre.setOnAction(event -> {
            supprimerParametre();
        });

        return root;
    }

    public Methode getMethode() {
        return methode;
    }

    private Parametre getSelectedParamatre() {
        return parametreListView.getSelectionModel().getSelectedItem();
    }

    /**
     * Permet la creation d'une nouvelle methode
     */
    private void creerMethode() {
        if (estValide()) {
            methode = new Methode();
            methode.setNom(textFieldNom.getText());
            methode.setVisibilite(comboBoxVisibilite.getValue());
            methode.setType(comboBoxType.getValue());
            ArrayList<Parametre> temp = new ArrayList<>();
            for (Parametre parametre : parametreListView.getItems())
                temp.add(parametre);
            methode.setParametres(temp);
            close();
        }
    }

    /**
     * Verifie la validite des entrees
     *
     * @return true si correct. false sinon
     */
    private boolean estValide() {
        if (textFieldNom.getText() == null || textFieldNom.getText().isEmpty() || comboBoxVisibilite.getSelectionModel().getSelectedItem() == null
                || comboBoxType.getSelectionModel().getSelectedItem() == null) {
            erreurLabel.setText("Tous les champs doivent etre remplis");
            return false;
        }
        erreurLabel.setText("");
        return true;
    }

    /**
     * Permet la creation d'un parametre
     */
    private void ajouterParametre() {
        FenetreAjouterParametre fenetreAjouterParametre = new FenetreAjouterParametre();
        fenetreAjouterParametre.showAndWait();
        if (fenetreAjouterParametre.getParametre() == null) return;
        parametreListView.getItems().add(fenetreAjouterParametre.getParametre());
    }

    /**
     * Permet la modification du parametre selectionne
     */
    private void modifierParametre() {
        if (getSelectedParamatre() == null) return;
        FenetreModifierParametre fenetreModifierParametre = new FenetreModifierParametre(getSelectedParamatre());
        fenetreModifierParametre.showAndWait();
        if (fenetreModifierParametre.getParametre() == null) return;
        Parametre temp = fenetreModifierParametre.getParametre();
        getSelectedParamatre().setNom(temp.getNom());
        getSelectedParamatre().setType(temp.getType());
        parametreListView.refresh();
    }

    /**
     * Permet la suppression du parametre selectionne
     */
    private void supprimerParametre() {
        if (getSelectedParamatre() == null) return;
        parametreListView.getItems().remove(parametreListView.getSelectionModel().getSelectedItem());
    }
}
