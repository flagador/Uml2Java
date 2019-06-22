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
import model.Attribut;
import model.Classe;
import view.controls.Classe_;

public class FenetreNouvelleClasse extends Stage {

    private Classe classe;
    private Pane zoneUML;
    private TextArea zoneJava;
    private Uml2Java uml;
    private TextArea textJ = new TextArea();

    public TextArea getTextJ() {
		return textJ;
	}


	public void setTextJ(TextArea textJ) {
		this.textJ = textJ;
	}

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
    private Button supprimerAttribut = new Button("Supprimer");

    private VBox vBoxMethodesClasse = new VBox();
    private Label methodesLabel = new Label("Methodes :");
    private ListView<model.Methode> methodesList = new ListView<model.Methode>();
    ObservableList <model.Methode> itemsM;
    
    private HBox hBoxBoutonsMethodes = new HBox();
    private Button ajouterMethode = new Button("Ajouter");
    private Button modifierMethode = new Button("Modifier");
    private Button supprimerMethode = new Button("Supprimer");

    private ButtonBar buttonBar = new ButtonBar();
    private Button confirmer = new Button("Confirmer");
    private Button annuler = new Button("Annuler");

    public FenetreNouvelleClasse(Uml2Java uml) {
        this.uml = uml;
        this.setTitle("Classe");
        this.setResizable(false);

        this.initModality(Modality.APPLICATION_MODAL);

        Scene scene = new Scene(init(), 550, 500);
        this.setScene(scene);
        initEvents();
    }
    
    
    public ListView<Attribut> getAttributsList() {
		return attributsList;
	}

	public void setAttributsList(ListView<Attribut> attributsList) {
		this.attributsList = attributsList;
	}
	
	
    public ListView<model.Methode> getMethodesList() {
		return methodesList;
	}


	public void setMethodesList(ListView<model.Methode> methodesList) {
		this.methodesList = methodesList;
	}


	// Initialise les controls
    private Parent init() {
        GridPane root = new GridPane();
        
        Font police = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 12);
        Font police2 = Font.loadFont(getClass().getResourceAsStream("Comfortaa-Regular.ttf"), 10);
        classeLabel.setFont(police);
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
        
        root.setPadding(new Insets(20));
        hBoxBoutonsAttributs.setPadding(new Insets(5));
        hBoxBoutonsMethodes.setPadding(new Insets(5));
        vBoxAttributsClasse.setPadding(new Insets(5));
        vBoxMethodesClasse.setPadding(new Insets(5));
        hBoxBoutonsAttributs.setMargin(ajouterAttribut, new Insets(5));
        hBoxBoutonsAttributs.setMargin(modifierAttribut, new Insets(5));
        hBoxBoutonsAttributs.setMargin(supprimerAttribut, new Insets(5));
        hBoxBoutonsMethodes.setMargin(ajouterMethode, new Insets(5));
        hBoxBoutonsMethodes.setMargin(modifierMethode, new Insets(5));
        hBoxBoutonsMethodes.setMargin(supprimerMethode, new Insets(5));
        hBoxNomClasse.setMargin(classeLabel, new Insets(5));
        

        hBoxNomClasse.getChildren().addAll(classeLabel, classeTextArea);

        vBoxAttributsClasse.getChildren().addAll(attributsLabel, attributsList, hBoxBoutonsAttributs);
        hBoxBoutonsAttributs.getChildren().addAll(ajouterAttribut, modifierAttribut, supprimerAttribut);

        vBoxMethodesClasse.getChildren().addAll(methodesLabel, methodesList, hBoxBoutonsMethodes);
        hBoxBoutonsMethodes.getChildren().addAll(ajouterMethode, modifierMethode, supprimerMethode);

        buttonBar.getButtons().addAll(confirmer, annuler);

        root.add(hBoxNomClasse, 0, 0, 4, 1);
        root.add(vBoxAttributsClasse, 0, 1);
        root.add(vBoxMethodesClasse, 1, 1);
        root.add(buttonBar, 1, 2);
        return root;
    }
    
    
    private void initEvents() {
        ajouterAttribut.setOnAction(event -> {
        	FenetreAttribut fenetreAttribut = new FenetreAttribut(this, classe);
            
            fenetreAttribut.show();
        });
        
        modifierAttribut.setOnAction(event -> {
        	
        	attributsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	
        	model.Attribut a;
        	a = attributsList.getSelectionModel().getSelectedItem();
        	
        	FenetreAttribut fenetreAttribut = new FenetreAttribut(this, classe);
            
        	fenetreAttribut.getTextFieldNom().setText(a.getNom());
        	fenetreAttribut.getComboBoxType().setValue(a.getType());
        	fenetreAttribut.getComboBoxVisibilite().setValue(a.getVisibilite());
        	
        	attributsList.getItems().remove(a);
        	
            fenetreAttribut.show();
        	
        });
        
        supprimerAttribut.setOnAction(event -> {
        	attributsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	
        	model.Attribut a;
        	a = attributsList.getSelectionModel().getSelectedItem();
        	
        	attributsList.getItems().remove(a);
        });

        ajouterMethode.setOnAction(event -> {
        	FenetreMethode fenetreMethode = new FenetreMethode(this, classe);
        	
        	methodesList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	
        	fenetreMethode.show();
        });
        
        modifierMethode.setOnAction(event -> {
        	
        	methodesList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	
        	model.Methode m;
        	m = methodesList.getSelectionModel().getSelectedItem();
        	
        	FenetreMethode fenetreMethode = new FenetreMethode(this, classe);
            
        	fenetreMethode.getTextFieldNom().setText(m.getNom());
        	fenetreMethode.getComboBoxType().setValue(m.getType());
        	fenetreMethode.getComboBoxVisibilite().setValue(m.getVisibilite());
        	
        	methodesList.getItems().remove(m);
        	
        	fenetreMethode.show();
        	
        });
        
        supprimerMethode.setOnAction(event -> {
        	methodesList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	
        	model.Methode m;
        	m = methodesList.getSelectionModel().getSelectedItem();
        	
        	methodesList.getItems().remove(m);
        });
        
        annuler.setOnAction(event -> {
            annulerClasse();
        });

        confirmer.setOnAction(event -> {
            ajouterClasse();
            
            int i = 0;
            
            for(i = 0; i < attributsList.getItems().size(); i++) {
            	
            	classe.ajoutAttribut(attributsList.getItems().get(i));
    			
    		}
            
            for(i = 0; i < methodesList.getItems().size(); i++) {
            	
            	classe.ajoutMethode(methodesList.getItems().get(i));
    			
    		}

    		//this.uml.getJavaCode().appendText(this.trad(classe));
            this.uml.printAllClasses();
            
        });
    }

    public void setZoneUML(Pane zoneUML) {
        this.zoneUML = zoneUML;
    }
    
    public void setZoneJava(TextArea zoneJava) {
    	this.zoneJava = zoneJava;
    }

    private void ajouterClasse() {
        this.classe = new Classe(classeTextArea.getText());
        if (estValide() && zoneUML != null) {
            Classe_ classe_ = new Classe_(classe);
            zoneUML.getChildren().add(classe_);
            
            
            uml.items = FXCollections.observableArrayList(classe);
            
        	uml.getClasseList().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	
        	uml.getClasseList().getItems().add(classe);
        	
        	Application.APP.ajoutClasse(classe);
            
//            zoneJava.setText(classe.traductionJava());
//            System.out.println(zoneJava);
            
            //textJ.setText(classe.traductionJava());
            //uml.setJavaCode(new TextArea(trad(classe)));
            
            //uml.getJavaCode() = new TextArea(trad(classe));
            
            close();
        }
    }
    
    public String trad(Classe classe) {
    	
    	return classe.traductionJava();
    	
    }

    public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
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
