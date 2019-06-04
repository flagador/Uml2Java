package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Attribut;
import model.Classe;
import view.controls.Classe_;

public class FenetreNouvelleClasse extends Stage {

    private Classe classe;
    private Pane zoneUML;

    private HBox hBoxNomClasse = new HBox();
    private Label classeLabel = new Label("Nom de la classe :");
    private TextField classeTextArea = new TextField();

    private VBox vBoxAttributsClasse = new VBox();
    private Label attributsLabel = new Label("Attributs :");
    private ListView<Attribut> attributsList = new ListView<Attribut>();
    ObservableList <Attribut> items;
   
	private HBox hBoxBoutonsAttributs = new HBox();
    private Button ajouterAttribut = new Button("Ajouter");
    private Button modifierAttribut = new Button("Modifier");
    private Button supprimerAttribu = new Button("Supprimer");

    private VBox vBoxMethodesClasse = new VBox();
    private Label methodesLabel = new Label("Methodes :");
    private ListView<Object> methodesList = new ListView<>();
    private HBox hBoxBoutonsMethodes = new HBox();
    private Button ajouterMethode = new Button("Ajouter");
    private Button modifierMethode = new Button("Modifier");
    private Button supprimerMethode = new Button("Supprimer");

    private ButtonBar buttonBar = new ButtonBar();
    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");

    public FenetreNouvelleClasse() {
        this.classe = new Classe();
        this.setTitle("Classe");
        this.setResizable(false);

        this.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(init(), 500, 500);
        this.setScene(scene);
        initEvents();
    }
    
    
    public ListView<Attribut> getAttributsList() {
		return attributsList;
	}

	public void setAttributsList(ListView<Attribut> attributsList) {
		this.attributsList = attributsList;
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
            FenetreAttribut fenetreAttribut = new FenetreAttribut(this);
            
            fenetreAttribut.show();
        });

        annuler.setOnAction(event -> {
            annulerClasse();
        });

        confirmer.setOnAction(event -> {
            ajouterClasse();
        });
    }

    public void setZoneUML(Pane zoneUML) {
        this.zoneUML = zoneUML;
    }

    private void ajouterClasse() {
        if (estValide() && zoneUML != null) {
            classe.setNom(classeTextArea.getText());
            Classe_ classe_ = new Classe_(classe);
            zoneUML.getChildren().add(classe_);
            close();
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
