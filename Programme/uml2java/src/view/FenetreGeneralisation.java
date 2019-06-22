package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Application;
import model.Generalisation;
import model.Attribut;
import model.Classe;
import model.Generalisation;
import view.controls.Classe_;

public class FenetreGeneralisation extends Stage {

    private Pane zoneUML;
	private Uml2Java uml;
    private Generalisation generalisation;

	private HBox hBoxNomgeneralisation = new HBox();
    private Label generalisationLabel = new Label("Nom de la generalisation :");
    private TextField classeTextArea = new TextField();

    private VBox vBoxGeneralisation = new VBox();
    private ComboBox<Classe> classe1 = new ComboBox();
    
    private VBox vBoxGeneralisation2 = new VBox();
    private ComboBox<Classe> classe2 = new ComboBox();
    

    private Classe[] comboClasse = new Classe[20];
    
    private ButtonBar buttonBar = new ButtonBar();
    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");

    public FenetreGeneralisation(Uml2Java uml) {
        this.uml = uml;
        this.setTitle("Generalisation");
        this.setResizable(false);

        this.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(init(), 380, 150);
        this.setScene(scene);
        initEvents();
    }


	// Initialise les controls
    private Parent init() {
        GridPane root = new GridPane();
        
        Font police = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 12);
        Font police2 = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 10);
        generalisationLabel.setFont(police);
        annuler.setFont(police);
        confirmer.setFont(police);
        
        annuler.getStyleClass().add("annuler");
        
        root.setPadding(new Insets(20));
        vBoxGeneralisation.setPadding(new Insets(5));
        vBoxGeneralisation2.setPadding(new Insets(5));

        vBoxGeneralisation.setMargin(classe1, new Insets(5));
        vBoxGeneralisation2.setMargin(classe2, new Insets(5));
        hBoxNomgeneralisation.setMargin(generalisationLabel, new Insets(5));

        classe1.setPrefWidth(170);
        classe2.setPrefWidth(170);
        
        int i = 0;
        
        for(i = 0; i < uml.getClasseList().getItems().size(); i++) {
        	
			comboClasse[i] = uml.getClasseList().getItems().get(i);
			
		}
        
        classe1.getItems().addAll(comboClasse);
        classe2.getItems().addAll(comboClasse);
        
        hBoxNomgeneralisation.getChildren().addAll(generalisationLabel, classeTextArea);

        vBoxGeneralisation.getChildren().addAll(classe1);
        vBoxGeneralisation2.getChildren().addAll(classe2);

        buttonBar.getButtons().addAll(confirmer, annuler);

        root.add(hBoxNomgeneralisation, 0, 0, 4, 1);
        root.add(vBoxGeneralisation, 0, 1);
        root.add(vBoxGeneralisation2, 1, 1);
        root.add(buttonBar, 1, 2);
        return root;
    }
    
    
    private void initEvents() {
     
        
        annuler.setOnAction(event -> {
            annulerClasse();
        });

        confirmer.setOnAction(event -> {
            Classe c;
        	Classe c2;
        	
        	c = classe1.getSelectionModel().getSelectedItem();
        	c2= classe2.getSelectionModel().getSelectedItem();
        	
        	/*
        	 switch(mult.getSelectionModel().getSelectedItem()) {
    			case("1 a n"):
    				generalisation = new Generalisation(c,c2,"1","n",classeTextArea.getText());
    				generalisation.unAn(c.getNom(), c2.getNom());
    			break;
    			case("n a 1"):
    				generalisation = new Generalisation(c2,c,"n","1",classeTextArea.getText());
    				generalisation.unAn(c2.getNom(), c.getNom());
    			break;
    			default:
    				generalisation = new Generalisation(c,c2,"1","1",classeTextArea.getText());
    				generalisation.unAun(c.getNom(), c2.getNom());
    			break;
    			
        	}
        	*/
        	generalisation = new Generalisation("generalisation",c,c2);
        	

        	c.ajoutRelation(generalisation);
        	c2.ajoutRelation(generalisation);

        	generalisation.setEnfant(c);
        	generalisation.setParent(c2);

        	Application.APP.ajoutGeneralisation(generalisation);
        	this.uml.printAllClasses();
            ajouterClasse();
            
        });
    }

    private void ajouterClasse() {
        if (estValide()) {
            
//        	uml.items = FXCollections.observableArrayList(classe);
//            
//        	uml.getClasseList().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        	
//        	uml.getClasseList().getItems().add(attribut);
        	
        	//zoneUML.getChildren().add();
        	
        	
        	
            close();
        }

    }
    
    public String trad(Classe classe) {
    	
    	return classe.traductionJava();
    	
    }

	private void annulerClasse() {
        close();
    }

    private boolean estValide() {
        if (classe1 == null || classe2 == null) {
            return false;
        }

        return true;
    }
}
