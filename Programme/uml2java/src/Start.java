import Views.MainView;
import com.sun.javafx.css.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new MainView("Uml2Java 0.1");
        primaryStage.show();
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        ChangeTheme("LightTheme.css");
    }

    public static void ChangeTheme(String path){
        StyleManager.getInstance().addUserAgentStylesheet(path);
    }
}
