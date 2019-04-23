package GUI;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Class_ extends GridPane {

    private boolean isPrivate;
    private boolean isPublic;
    private boolean isAbstract;
    private boolean isProtected;

    private Text className = new Text("ClassName");

    private VBox classAttribut = new VBox();
    private VBox classMethodes = new VBox();

    public Class_(){
        this.prefHeight(150);
        this.prefWidth(100);
        this.add(className, 0, 0);
        this.add(classAttribut, 0, 1);
        this.add(classMethodes, 0, 1);
    }
}
