package Assignment_1.tiles;

import javafx.scene.paint.Color;

// intrinsic state
public class TileGraphic {
    private final Color color;

    public TileGraphic(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
