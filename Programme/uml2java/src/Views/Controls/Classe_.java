package Views.Controls;

import Models.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

public class Classe_ extends VBox {

    private Classe classe;

    private Label nomLabel = new Label();

    private VBox nomVBox = new VBox();
    private VBox attributsVBox = new VBox();
    private VBox methodesVBox = new VBox();

    public Classe_(Classe classe) {
        this.classe = classe;

        nomLabel.textProperty().bind(classe.nomProperty());
        nomVBox.getChildren().addAll(nomLabel);

        this.getChildren().addAll(nomVBox, attributsVBox, methodesVBox);
    }


}
