package GUI;

import javafx.event.Event;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Principale extends Stage {

    public Principale() {
        this.setTitle("Uml2Java");

        this.setResizable(false);

        Scene scene = new Scene(init());
        this.setScene(scene);
        this.sizeToScene();
    }

    /**
     *Initialise l'interface
     */
    private Parent init() {
        BorderPane root = new BorderPane();

        root.setMinSize(1000, 750);

        // Menu
        MenuBar menuBar = new MenuBar();

        Menu fichier = new Menu("Fichier");
        MenuItem_ nouveau = new MenuItem_("Nouveau",null, new KeyCodeCombination(KeyCode.N, KeyCodeCombination.CONTROL_DOWN));
        MenuItem_ ouvrir = new MenuItem_("Ouvrir...", null, new KeyCodeCombination(KeyCode.O, KeyCodeCombination.CONTROL_DOWN));
        MenuItem_ enregistrer = new MenuItem_("Enregistrer...", null, new KeyCodeCombination(KeyCode.O, KeyCodeCombination.CONTROL_DOWN));
        fichier.getItems().addAll(nouveau, ouvrir, new SeparatorMenuItem(), enregistrer);

        Menu edit = new Menu("Edit");

        Menu aide = new Menu("Aide");

        menuBar.getMenus().addAll(fichier, edit, aide);

        TreeItem<String> treeTitle = new TreeItem<String>("TreeView");
        TreeView<String> treeView = new TreeView<String>(treeTitle);

        // Tabs
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Uml Tab
        Tab tabUml = new Tab("Uml");
        BorderPane umlRoot = new BorderPane();
        Pane canvas = new Pane();
        ToolBar toolBarUml = new ToolBar();
        Button_ newClass = new Button_("Nouvelle Classe");
        Button_ assoUni = new Button_("Association Unidirectionnelle");
        Button_ assoBi = new Button_("Association Bidirectionnelle");
        Button_ generalisation = new Button_("Generalisation");
        Button_ dependance = new Button_("Dependance");
        toolBarUml.getItems().addAll(newClass, assoUni, assoBi, generalisation, dependance);

        umlRoot.setTop(toolBarUml);
        tabUml.setContent(umlRoot);

        // Java Tab
        Tab tabJava = new Tab("Java");
        BorderPane javaRoot = new BorderPane();
        TextArea textArea = new TextArea("Code Java ....");
        javaRoot.setCenter(textArea);
        tabJava.setContent(javaRoot);

        tabPane.getTabs().addAll(tabUml, tabJava);


        newClass.setOnMouseClicked(e -> {
            Class_ c = new Class_();

            System.out.println("newClass bouton cliqué");
            canvas.getChildren().addAll(c);
            System.out.println("classe ajouter");

        });


        root.setTop(menuBar);
        root.setLeft(treeView);
        root.setCenter(tabPane);
        return root;
    }
}
