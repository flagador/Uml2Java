package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Button_ extends javafx.scene.control.Button {

    /**
     * Button Personallisé
     * @param text
     * @param image
     */
    public Button_(String text, Image image) {
        this.setText(text);
        this.setGraphic(new ImageView(image));
    }

    /**
     * Button Personallisé
     * @param text
     */
    public Button_(String text){
        this.setText(text);

    }

    /**
     * Button Personallisé
     * @param image
     */
    public Button_(Image image){
        this.setGraphic(new ImageView(image));

    }
}
