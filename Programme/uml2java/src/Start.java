import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.stage.Stage;
import view.Uml2Java;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage = new Uml2Java("Uml2Java");
        primaryStage.show();

        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        StyleManager.getInstance().addUserAgentStylesheet("Stylesheet.css");

    }
}
