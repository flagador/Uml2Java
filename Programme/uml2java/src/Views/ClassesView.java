package Views;

import Models.*;
import Views.Controls.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ClassesView extends Stage {

    private HBox hBoxNomClasse = new HBox();
    private Label classeLabel = new Label("Nom de la classe :");
    private TextField classeTextArea = new TextField();

    private VBox vBoxAttributsClasse = new VBox();
    private Label attributsLabel = new Label("Attributs :");
    private ListView<Object> attributsList = new ListView<>();
    private HBox hBoxBoutonsAttributs = new HBox();
    private Button ajouterAttribut = new Button("Ajouter");
    private Button modifierAttribut = new Button("Modifier");
    private Button supprimerAttribu = new Button("Supprimer");

    private VBox vBoxMethodesClasse = new VBox();
    private Label methodesLabel = new Label("Attributs :");
    private ListView<Object> methodesList = new ListView<>();
    private HBox hBoxBoutonsMethodes = new HBox();
    private Button ajouterMethode = new Button("Ajouter");
    private Button modifierMethode = new Button("Modifier");
    private Button supprimerMethode = new Button("Supprimer");

    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");

    public ClassesView(Classe classe) {
        this.setTitle("Classe");
        this.setResizable(false);

        this.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(init(), 500, 500);
        this.setScene(scene);

        classeTextArea.textProperty().bindBidirectional(classe.nomProperty());
    }

    // Initialise les controls
    private Parent init() {
        GridPane root = new GridPane();

        hBoxNomClasse.getChildren().addAll(classeLabel, classeTextArea);

        vBoxAttributsClasse.getChildren().addAll(attributsLabel, attributsList, hBoxBoutonsAttributs);
        hBoxBoutonsAttributs.getChildren().addAll(ajouterAttribut, modifierAttribut, supprimerAttribu);

        vBoxMethodesClasse.getChildren().addAll(methodesLabel, methodesList, hBoxBoutonsMethodes);
        hBoxBoutonsMethodes.getChildren().addAll(ajouterMethode, modifierMethode, supprimerMethode);



        root.add(hBoxNomClasse, 0, 0);
        root.add(vBoxAttributsClasse, 0, 1);
        root.add(vBoxMethodesClasse, 1, 1);
        return root;
    }
}
