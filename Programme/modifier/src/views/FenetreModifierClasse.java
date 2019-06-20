package views;

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
        this.setTitle("Nouvelle classe");
        this.setResizable(false);
        this.initModality(Modality.APPLICATION_MODAL);

        this.setScene(new Scene(initControls()));
        this.sizeToScene();
        initEvents();
        afficherInfo();
    }

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


        return root;
    }

    private void initEvents() {
        confirmer.setOnAction(event -> {
            sauvgarderClasse();
        });
    }

    public Classe getClasse() {
        return this.classe;
    }

    private void sauvgarderClasse() {
        if (estValide()) {
            classe = new Classe();
            classe.setNom(nomClasseTextArea.getText());
            this.close();
        }
    }

    private void afficherInfo() {
        if (classe == null) return;
        nomClasseTextArea.setText(classe.getNom());
        attributsList.setItems(FXCollections.observableList(classe.getAttributs()));
        methodesList.setItems(FXCollections.observableArrayList(classe.getMethodes()));
    }

    /**
     * Teste la validite des info
     *
     * @return true si valide
     */
    private boolean estValide() {
        if (nomClasseTextArea.getText() == null || nomClasseTextArea.getText().isEmpty()) {
            nomClasseTextArea.setText("Le nom de classe est obligatoire");
            return false;
        }
        return true;
    }
}
