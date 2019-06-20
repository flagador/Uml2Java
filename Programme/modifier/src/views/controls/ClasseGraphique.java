package views.controls;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.Attribut;
import models.Classe;
import models.Methode;

public class ClasseGraphique extends VBox {

    Classe classe;

    private Label nomClasse = new Label();
    private VBox attributList = new VBox();
    private VBox methodeList = new VBox();

    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;

    public ClasseGraphique(Classe classe) {
        this.classe = classe;
        this.setId("classe");
        initControls();
        afficherClasse();
        initEvents();
    }

    private void initControls() {
        this.getChildren().addAll(nomClasse, attributList, methodeList);
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

            // if ((newTranslateX > 0 && newTranslateX < Principale.getMaxX()) && (newTranslateY > 0 && newTranslateY < Principale.getMaxY())) {
            ((VBox) (event.getSource())).setTranslateX(newTranslateX);
            ((VBox) (event.getSource())).setTranslateY(newTranslateY);
            // }

        });
    }

    public void afficherClasse() {
        if (classe == null) return;
        nomClasse.setText(classe.getNom());
        attributList.getChildren().clear();
        methodeList.getChildren().clear();
        for (Attribut attribut : classe.getAttributs()) attributList.getChildren().add(new Text(attribut.toString()));
        for (Methode methode : classe.getMethodes()) methodeList.getChildren().addAll(new Text(methode.toString()));
    }

}
