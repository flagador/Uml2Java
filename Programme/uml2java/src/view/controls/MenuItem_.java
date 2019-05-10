package view.controls;

import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class MenuItem_ extends MenuItem {

    /**
     * Constructs a MenuItem with no display text.
     */
    public MenuItem_() {
        super();
    }

    /**
     * Constructs a MenuItem and sets the display text with the specified text
     *
     * @param text text to display
     * @see #setText
     */
    public MenuItem_(String text) {
        super(text);
    }

    /**
     * Constructs a MenuItem and sets the display text with the specified text
     * and KeyShortcut
     *
     * @param text text to display
     * @param keyCodeCombination key shortcuts
     * @see #setText
     * @see #setAccelerator(KeyCombination)
     */
    public MenuItem_(String text, KeyCodeCombination keyCodeCombination) {
        super(text);
        this.setAccelerator(keyCodeCombination);
    }

    /**
     * Constructor s MenuItem and sets the display text with the specified text
     * and sets the graphic {@link Node} to the given node.
     *
     * @see #setText
     * @see #setGraphic
     */
    public MenuItem_(String text, Node graphic) {
        super(text, graphic);
    }

    /**
     * Constructor s MenuItem and sets the display text with the specified text
     * and sets the graphic {@link Node} to the given node and KeyShortcut.
     *
     * @see #setText
     * @see #setGraphic
     * @see #setAccelerator(KeyCombination)
     */
    public MenuItem_(String text, Node graphic, KeyCodeCombination keyCodeCombination) {
        super(text, graphic);
        this.setAccelerator(keyCodeCombination);
    }
}
