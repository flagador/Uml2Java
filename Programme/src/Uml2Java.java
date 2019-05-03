import javafx.application.Application;
import javafx.stage.Stage;
import GUI.Principale;

public class Uml2Java extends Application{

    private static Principale root = new Principale();

    public static void main(String[] args) {
        Application.launch();
    }

    public void start(Stage primaryStage){
        root.show();
    }
}
