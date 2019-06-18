package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Classe;
import view.controls.MenuItem_;

public class Uml2Java extends Stage {

    private MenuBar menuBar = new MenuBar();

    private Menu      ficherMenu  = new Menu("Fichier");
    private MenuItem_ nouveau     = new MenuItem_("Nouveau", new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
    private MenuItem_ ouvrir      = new MenuItem_("Ouvrir", new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
    private MenuItem_ enregistrer = new MenuItem_("Enregistrer", new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
    private MenuItem_ quitter     = new MenuItem_("Quitter", new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));

    private Menu      aideMenu = new Menu("Aide");
    private MenuItem_ aide     = new MenuItem_("Aide");
    private MenuItem_ aPropos  = new MenuItem_("A Propos");

    private TreeView<String> treeView       = new TreeView<>();
    private TreeItem<String> treeItemHeader = new TreeItem<>("Project");

    private TabPane tabPane = new TabPane();
    private Tab     umlTab  = new Tab("UML");
    private Tab     javaTab = new Tab("Java");

    private ToolBar umlToolBar = new ToolBar();

    private BorderPane rootUml = new BorderPane();
    private Pane       umlPane = new Pane();

    private TextArea javaCode = new TextArea("Java Code ...");

    private ContextMenu contextMenu = new ContextMenu();

    private Button nouvClasse = new Button("Classe");
    private Button nouvAsso = new Button("Association");
    private Button nouvGene = new Button("Generalisation");
    private Button nouvDep = new Button("Dependance");

    public Uml2Java(String title) {
        this.setTitle(title);

        Scene scene = new Scene(init(), 800, 700);
        
        initEvents();
        this.setScene(scene);
    }

    private Parent init() {
        BorderPane root = new BorderPane();
        
        
        
        nouvClasse.getStyleClass ().add("Button");
        nouvAsso.getStyleClass ().add("Button");
        nouvGene.getStyleClass ().add("Button");
        nouvDep.getStyleClass ().add("Button");
        umlToolBar.setId("menuColor");
        umlTab.setId("menuColor");
        javaTab.setId("javaMenu");
        root.setId("rootColor");
        
        menuBar.getMenus().addAll(ficherMenu, aideMenu);
        ficherMenu.getItems().addAll(nouveau, ouvrir, enregistrer, quitter);
        aideMenu.getItems().addAll(aide, aPropos);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(umlTab, javaTab);

        umlTab.setContent(rootUml);
        umlTab.setContextMenu(contextMenu);
        rootUml.setTop(umlToolBar);
        rootUml.setCenter(umlPane);
        umlToolBar.getItems().addAll(nouvClasse, nouvAsso, nouvGene, nouvDep);
        treeView.setRoot(treeItemHeader);

        javaTab.setContent(javaCode);

        root.setTop(menuBar);
        root.setLeft(treeView);
        root.setCenter(tabPane);
        return root;
    }


    private void initEvents() {
        nouvClasse.setOnMouseClicked(e -> {
            nouvelleClasse();
            //System.out.print("InitEvent");
        });
    }

    private void nouvelleClasse() {
        // Execute lors de la creation d'une nouvelle classe
    	//System.out.println("nouvelleClasse");
        FenetreNouvelleClasse fenetreNouvelleClasse = new FenetreNouvelleClasse();
        fenetreNouvelleClasse.setZoneUML(umlPane);
        fenetreNouvelleClasse.show();
    }
}

