package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCodeCombination;

public class MenuItem_ extends javafx.scene.control.MenuItem {

    /**
     * MenuItem Personallisé
     * @param text
     * @param image
     * @param keyCodeCombination
     */
    public MenuItem_(String text, Image image, KeyCodeCombination keyCodeCombination){
        this.setText(text);
        this.setGraphic(new ImageView(image));
        this.setAccelerator(keyCodeCombination);

    }
}
