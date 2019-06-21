package views.controls;

import javafx.scene.Node;
import javafx.scene.input.KeyCodeCombination;

public class MenuItem extends javafx.scene.control.MenuItem {

    /**
     * Instantiates a new Menu item.
     *
     * @param value the value to display
     */
    public MenuItem(String value) {
        super(value);
    }

    /**
     * Instantiates a new Menu item.
     *
     * @param value    the value to display
     * @param shortcut the shortcut
     * @param image    the image
     */
    public MenuItem(String value, KeyCodeCombination shortcut, Node image) {
        super(value, image);
        super.setAccelerator(shortcut);
    }
}
