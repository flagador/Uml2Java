package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Attribut;
import model.Classe;
import view.controls.Classe_;

import java.util.ArrayList;
import java.util.List;

public class FenetreClasse extends Stage {

    Classe classe;
    Parent zoneUML;

    private HBox      hBoxNomClasse  = new HBox();
    private Label     classeLabel    = new Label("Nom de la classe :");
    private TextField classeTextArea = new TextField();

    private VBox             vBoxAttributsClasse  = new VBox();
    private Label            attributsLabel       = new Label("Attributs :");
    private ListView<Attribut> attributsList        = new ListView<Attribut>();
    private HBox             hBoxBoutonsAttributs = new HBox();
    private Button           ajouterAttribut      = new Button("Ajouter");
    private Button           modifierAttribut     = new Button("Modifier");
    private Button           supprimerAttribu     = new Button("Supprimer");

    private VBox             vBoxMethodesClasse  = new VBox();
    private Label            methodesLabel       = new Label("Methodes :");
    private ListView<Object> methodesList        = new ListView<>();
    private HBox             hBoxBoutonsMethodes = new HBox();
    private Button           ajouterMethode      = new Button("Ajouter");
    private Button           modifierMethode     = new Button("Modifier");
    private Button           supprimerMethode    = new Button("Supprimer");

    private ButtonBar buttonBar = new ButtonBar();
    private Button confirmer = new Button("Confirmer");
    private Button annuler   = new Button("Annuler");

    /**
     * Constructeur
     * @param classe
     */
    public FenetreClasse(Classe classe, Parent zoneUML) {
        this.classe = classe;
        this.zoneUML = zoneUML;
        this.setTitle("Classe");
        this.setResizable(false);

        this.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(init(), 500, 500);
        this.setScene(scene);
        initEvents();
    }

    // Initialise les controls
    private Parent init() {
        GridPane root = new GridPane();

        hBoxNomClasse.getChildren().addAll(classeLabel, classeTextArea);

        vBoxAttributsClasse.getChildren().addAll(attributsLabel, attributsList, hBoxBoutonsAttributs);
        hBoxBoutonsAttributs.getChildren().addAll(ajouterAttribut, modifierAttribut, supprimerAttribu);

        vBoxMethodesClasse.getChildren().addAll(methodesLabel, methodesList, hBoxBoutonsMethodes);
        hBoxBoutonsMethodes.getChildren().addAll(ajouterMethode, modifierMethode, supprimerMethode);

        buttonBar.getButtons().addAll(confirmer, annuler);

        root.add(hBoxNomClasse, 0, 0);
        root.add(vBoxAttributsClasse, 0, 1);
        root.add(vBoxMethodesClasse, 1, 1);
        root.add(buttonBar, 1, 2);
        return root;
    }

    private void initEvents() {
        ajouterAttribut.setOnAction(event -> {
            FenetreAttribut fenetreAttribut = new FenetreAttribut();
            fenetreAttribut.show();
        });
        annuler.setOnAction(event -> {
            annulerClasse();
        });
    }

    private void afficherClasse() {
        if (classe != null) {
            classeTextArea.setText(classe.getNom());

        } else {
            classeTextArea.setText(null);
        }

    }

    private void ajouterClasse() {
        if (estValide()) {
            if (this.classe == null) {
                this.classe = new Classe();
                classe.setNom(classeTextArea.getText());
                ArrayList<Attribut> tempAtt = new ArrayList<Attribut>(attributsList.getItems());
                classe.setAttributs(tempAtt);
            } else {
            }
            Classe_ classe_ = new Classe_(this.classe);
        }

    }

    private void annulerClasse() {
        close();
    }

    private boolean estValide() {
        if (classeTextArea.getText() == null || classeTextArea.getText().isEmpty()) {
            return false;
        }

        return true;
    }
}
