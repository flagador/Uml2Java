package views;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Attribut;
import models.Classe;
import models.Methode;

public class FenetreNouvelleClasse extends Stage {

    private Classe classe;

    private Label erreurLabel = new Label();

    private HBox hBoxNomClasse = new HBox();
    private Label nomClasseLabel = new Label("Nom de la classe :");
    private TextField nomClasseTextArea = new TextField();

    private Label attributsLabel = new Label("Attributs :");
    private ListView<Attribut> attributsList = new ListView<Attribut>();
    private ButtonBar buttonBarAttribut = new ButtonBar();
    private Button ajouterAttribut = new Button("Ajouter");
    private Button modifierAttribut = new Button("Modifier");
    private Button supprimerAttribut = new Button("Supprimer");

    private Label methodesLabel = new Label("Methodes :");
    private ListView<Methode> methodesList = new ListView<>();
    private ButtonBar buttonBarMethodes = new ButtonBar();
    private Button ajouterMethode = new Button("Ajouter");
    private Button modifierMethode = new Button("Modifier");
    private Button supprimerMethode = new Button("Supprimer");

    private ButtonBar buttonBar = new ButtonBar();
    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");

    public FenetreNouvelleClasse() {
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

        buttonBarAttribut.getButtons().addAll(ajouterAttribut, modifierAttribut, supprimerAttribut);
        buttonBarAttribut.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        buttonBarMethodes.getButtons().addAll(ajouterMethode, modifierMethode, supprimerMethode);
        buttonBarMethodes.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);

        buttonBar.getButtons().addAll(confirmer, annuler);

        hBoxNomClasse.getChildren().addAll(nomClasseLabel, nomClasseTextArea);
        hBoxNomClasse.setSpacing(10);
        root.add(hBoxNomClasse, 0, 0);
        root.add(buttonBar, 1, 4);

        // Attributs
        root.add(attributsLabel, 0, 1);
        root.add(attributsList, 0, 2);
        root.add(buttonBarAttribut, 0, 3);

        // Methodes
        root.add(methodesLabel, 1, 1);
        root.add(methodesList, 1, 2);
        root.add(buttonBarMethodes, 1, 3);

        // Erreur
        erreurLabel.setId("erreur");
        root.add(erreurLabel, 1, 0);

        modifierAttribut.disableProperty().bind(Bindings.isEmpty(attributsList.getSelectionModel().getSelectedItems()));
        supprimerAttribut.disableProperty().bind(Bindings.isEmpty(attributsList.getSelectionModel().getSelectedItems()));

        modifierMethode.disableProperty().bind(Bindings.isEmpty(methodesList.getSelectionModel().getSelectedItems()));
        supprimerMethode.disableProperty().bind(Bindings.isEmpty(methodesList.getSelectionModel().getSelectedItems()));

        return root;
    }

    private void initEvents() {
        confirmer.setOnAction(event -> {
            creerClasse();
        });
        annuler.setOnAction(event -> {
            close();
        });
        ajouterAttribut.setOnAction(event -> {
            ajouterAttribut();
        });
        modifierAttribut.setOnAction(event -> {
            modifierAttribut();
        });
        supprimerAttribut.setOnAction(event -> {
            supprimerAttribut();
        });
        ajouterMethode.setOnAction(event -> {
            ajouterMethode();
        });
        modifierMethode.setOnAction(event -> {

        });
        supprimerMethode.setOnAction(event -> {
            supprimerMethode();
        });
    }

    public Classe getClasse() {
        return this.classe;
    }

    private Attribut getSelectedAttribut() { return attributsList.getSelectionModel().getSelectedItem(); }

    private Methode getSelectedMethode() { return  methodesList.getSelectionModel().getSelectedItem(); }

    /**
     * Creer une nouvelle classe
     */
    private void creerClasse() {
        if (estValide()) {
            classe = new Classe();
            classe.setNom(nomClasseTextArea.getText());
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
