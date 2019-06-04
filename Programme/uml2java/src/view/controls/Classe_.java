package view.controls;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Classe;

public class Classe_ extends VBox {

    private Classe classe;

    private Text className = new Text("Class Name");
    private VBox classNameVBox = new VBox();
    private VBox attributsVBox = new VBox();
    private VBox methodesVBox = new VBox();

    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;

    public Classe_(Classe classe) {
        super();
        this.classe = classe;
        this.prefHeight(150);
        this.prefWidth(100);

        this.setId("Classe");

        classNameVBox.setStyle("-fx-border-color: black");
        attributsVBox.setStyle("-fx-border-color: black");
        methodesVBox.setStyle("-fx-border-color: black");

        initControls();
        initEvents();
        afficherClasse();
    }

    private void initControls() {
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().addAll(classNameVBox, attributsVBox, methodesVBox);

        classNameVBox.setAlignment(Pos.CENTER);
        classNameVBox.getChildren().add(className);
    }

    private void initEvents() {
        this.setOnMousePressed(event -> {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            orgTranslateX = ((VBox) (event.getSource())).getTranslateX();
            orgTranslateY = ((VBox) (event.getSource())).getTranslateY();
        });

        this.setOnMouseDragged(event -> {
            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;

            System.out.println(newTranslateX);
            System.out.println(newTranslateY);

            ((VBox) (event.getSource())).setTranslateX(newTranslateX);
            ((VBox) (event.getSource())).setTranslateY(newTranslateY);
        });
    }

    private void afficherClasse() {
        if (classe == null) return;
        className.setText(classe.getNom());
    }
}
