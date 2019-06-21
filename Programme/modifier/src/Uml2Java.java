import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.stage.Stage;
import views.FenetrePrincipal;

public class Uml2Java extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage = new FenetrePrincipal();
        primaryStage.show();

        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        StyleManager.getInstance().addUserAgentStylesheet("Stylesheet.css");
    }
}
