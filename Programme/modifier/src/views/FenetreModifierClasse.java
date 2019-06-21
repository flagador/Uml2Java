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
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Attribut;
import models.Classe;
import models.Methode;

public class FenetreModifierClasse extends Stage {

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

    public FenetreModifierClasse(Classe classe) {
        this.classe = classe;
        this.setTitle("Modifier classe");
        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);

        this.setScene(new Scene(initControls()));
        this.sizeToScene();
        initEvents();
        afficherClasse();
    }

    /**
     * Construit la fenetre
     *
     * @return le contenu de la fenetre
     */
    private Parent initControls() {
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        
        Font police = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 12);
        Font police2 = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 10);
        nomClasseLabel.setFont(police);
        attributsLabel.setFont(police);
        methodesLabel.setFont(police);
        ajouterAttribut.setFont(police2);
        modifierAttribut.setFont(police2);
        supprimerAttribut.setFont(police2);
        ajouterMethode.setFont(police2);
        modifierMethode.setFont(police2);
        supprimerMethode.setFont(police2);
        annuler.setFont(police);
        confirmer.setFont(police);
        
        annuler.getStyleClass().add("annuler");
        supprimerAttribut.getStyleClass().add("supprimer");
        supprimerMethode.getStyleClass().add("supprimer");

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

        annuler.setId("annuler");

        modifierAttribut.disableProperty().bind(Bindings.isEmpty(attributsList.getSelectionModel().getSelectedItems()));
        supprimerAttribut.disableProperty().bind(Bindings.isEmpty(attributsList.getSelectionModel().getSelectedItems()));

        modifierMethode.disableProperty().bind(Bindings.isEmpty(methodesList.getSelectionModel().getSelectedItems()));
        supprimerMethode.disableProperty().bind(Bindings.isEmpty(methodesList.getSelectionModel().getSelectedItems()));

        return root;
    }

    /**
     * Initialise les evenements
     */
    private void initEvents() {
        confirmer.setOnAction(event -> {
            modifierClasse();
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
            modifierMethode();
        });
        supprimerMethode.setOnAction(event -> {
            supprimerMethode();
        });
    }

    /**
     * @return la classe en cours de modification
     */
    public Classe getClasse() {
        return this.classe;
    }

    /**
     * @return l'attribut selectionne
     */
    private Attribut getSelectedAttribut() {
        return attributsList.getSelectionModel().getSelectedItem();
    }

    /**
     * @return la methode selectionne
     */
    private Methode getSelectedMethode() {
        return methodesList.getSelectionModel().getSelectedItem();
    }

    /**
     * Affiche les infos de la classe
     */
    private void afficherClasse() {
        if (classe == null) return;
        nomClasseTextArea.setText(classe.getNom());
        attributsList.setItems(FXCollections.observableArrayList(classe.getAttributs()));
        methodesList.setItems(FXCollections.observableArrayList(classe.getMethodes()));
    }

    /**
     * Modifie la classe
     */
    private void modifierClasse() {
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

    /**
     * Ajoute un attribut a la classe
     */
    private void ajouterAttribut() {
        FenetreAjouterAttribut fenetreAjouterAttribut = new FenetreAjouterAttribut();
        fenetreAjouterAttribut.showAndWait();
        if (fenetreAjouterAttribut.getAttribut() == null) return;
        attributsList.getItems().add(fenetreAjouterAttribut.getAttribut());
    }

    /**
     * Modifi l'attribut selectionne
     */
    private void modifierAttribut() {
        if (getSelectedAttribut() == null) return;
        FenetreModifierAttribut fenetreModifierAttribut = new FenetreModifierAttribut(getSelectedAttribut());
        fenetreModifierAttribut.showAndWait();
        if (fenetreModifierAttribut.getAttribut() == null) return;
        Attribut temp = fenetreModifierAttribut.getAttribut();
        getSelectedAttribut().setNom(temp.getNom());
        getSelectedAttribut().setType(temp.getType());
        getSelectedAttribut().setVisibilite(temp.getVisibilite());
        attributsList.refresh();
    }

    /**
     * Supprimer l'atribut selectionne
     */
    private void supprimerAttribut() {
        if (getSelectedAttribut() == null) return;
        attributsList.getItems().remove(attributsList.getSelectionModel().getSelectedIndex());
    }

    /**
     * Ajoute une methode a la classe
     */
    private void ajouterMethode() {
        FenetreAjouterMethode fenetreAjouterMethode = new FenetreAjouterMethode();
        fenetreAjouterMethode.showAndWait();
        if (fenetreAjouterMethode.getMethode() == null) return;
        methodesList.getItems().add(fenetreAjouterMethode.getMethode());
    }

    /**
     * Modifi la methode selectionne
     */
    private void modifierMethode() {
        if (getSelectedMethode() == null) return;
        FenetreModifierMethode fenetreModifierMethode = new FenetreModifierMethode(getSelectedMethode());
        fenetreModifierMethode.showAndWait();
        if (fenetreModifierMethode.getMethode() == null) return;
        Methode temp = fenetreModifierMethode.getMethode();
        getSelectedMethode().setNom(temp.getNom());
        getSelectedMethode().setParametres(temp.getParametres());
        getSelectedMethode().setType(temp.getType());
        getSelectedMethode().setVisibilite(temp.getVisibilite());
        methodesList.refresh();
    }

    /**
     * Supprime la methode selectionne
     */
    private void supprimerMethode() {
        if (getSelectedMethode() == null) return;
        methodesList.getItems().remove(methodesList.getSelectionModel().getSelectedIndex());
    }
}
