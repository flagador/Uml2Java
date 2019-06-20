package views;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Classe;
import views.controls.ClasseGraphique;
import views.controls.MenuItem;
import ressources.fonts.*;

public class FenetrePrincipal extends Stage {

    private MenuBar menuBar = new MenuBar();

    private Menu menuFicher = new Menu("Fichier");
    private MenuItem nouveau = new MenuItem("Nouveau", new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN), null);
    private MenuItem ouvrir = new MenuItem("Ouvrir", new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN), null);
    private MenuItem enregistrer = new MenuItem("Enregistrer", new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN), null);
    private MenuItem quitter = new MenuItem("Quitter", new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN), null);

    private Menu menuAide = new Menu("Aide");
    private MenuItem aide = new MenuItem("Aide", new KeyCodeCombination(KeyCode.F1), null);
    private MenuItem aPropos = new MenuItem("A Propos", new KeyCodeCombination(KeyCode.F10), null);

    private TreeView<String> treeView = new TreeView<>();
    private TreeItem<String> treeItemHeader = new TreeItem<>("Project");

    private TabPane tabPane = new TabPane();
    private Tab umlTab = new Tab("UML");
    private Tab javaTab = new Tab("Java");

    private ToolBar umlToolBar = new ToolBar();

    private BorderPane rootUml = new BorderPane();
    private Pane umlPane = new Pane();
    private ScrollPane zoneDessin = new ScrollPane(umlPane);

    private TextArea javaCode = new TextArea("Java Code ...");

    private ContextMenu contextMenu = new ContextMenu();

    private Button nouvClasse = new Button("Classe");
    private Button nouvAsso = new Button("Association");
    private Button nouvGene = new Button("Generalisation");
    private Button nouvDep = new Button("Dependance");

    public FenetrePrincipal() {
        this.setTitle("Uml2Java");
        this.setHeight(600.0);
        this.setWidth(800.0);
        this.setResizable(false);

        this.setScene(new Scene(iniControls()));
        initEvents();
    }

    /**
     * Construit la fenetre
     *
     * @return Default Controls
     */
    private Parent iniControls() {
        BorderPane root = new BorderPane();

        // Police et couleur
        Font police = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 12);
        javaCode.setFont(police);
        nouvClasse.setFont(police);
        nouvAsso.setFont(police);
        nouvGene.setFont(police);
        nouvDep.setFont(police);
        
        umlToolBar.setId("menuColor");
        umlTab.setId("menuColor");
        javaTab.setId("javaMenu");
        root.setId("rootColor");
        rootUml.setId("rootColor");
        zoneDessin.setId("rootColor");
        
        // Top
        menuFicher.getItems().addAll(nouveau, enregistrer, ouvrir, quitter);
        menuAide.getItems().addAll(aide, aPropos);
        menuBar.getMenus().addAll(menuFicher, menuAide);

        // Left
        treeView.setRoot(treeItemHeader);

        // Center
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(umlTab, javaTab);

        // Center - Uml
        umlToolBar.getItems().addAll(nouvClasse, nouvAsso, nouvDep, nouvGene);
        rootUml.setTop(umlToolBar);
        rootUml.setCenter(zoneDessin);
        umlTab.setContent(rootUml);

        // Center - Java
        javaTab.setContent(javaCode);

        root.setTop(menuBar);
        root.setLeft(treeView);
        root.setCenter(tabPane);
        return root;
    }

    /**
     * Initialise les evenements lies aux controls
     */
    private void initEvents() {
        nouvClasse.setOnAction(event -> {
            nouvelleClasse();
        });

        nouvAsso.setOnAction(event -> {
        });

    }

    /**
     * Creer une nouvelle classe et l'affiche a l'ecran
     */
    private void nouvelleClasse() {
        FenetreNouvelleClasse dialog = new FenetreNouvelleClasse();
        dialog.showAndWait();
        if (dialog.getClasse() == null) return;
        ClasseGraphique classeGraphique =  new ClasseGraphique(dialog.getClasse());
        classeGraphique.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                FenetreModifierClasse fenetreModifierClasse = new FenetreModifierClasse(dialog.getClasse());
                fenetreModifierClasse.showAndWait();
                Classe temp = fenetreModifierClasse.getClasse();
                if (temp == null) return;
                dialog.getClasse().setNom(temp.getNom());
                dialog.getClasse().setAttributs(temp.getAttributs());
                dialog.getClasse().setMethodes(temp.getMethodes());
                classeGraphique.afficherClasse();
            }

        });
        umlPane.getChildren().add(classeGraphique);

    }
}
