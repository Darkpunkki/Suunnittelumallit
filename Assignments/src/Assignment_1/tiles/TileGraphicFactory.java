package Assignment_1.tiles;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, TileGraphic> graphics = new HashMap<>();

    public static TileGraphic getGraphic(String type) {
        return graphics.computeIfAbsent(type, t -> {
            System.out.println("Creating new TileGraphic for type: " + t);
            switch (t) {
                case "building": return new TileGraphic(Color.GRAY);
                case "forest": return new TileGraphic(Color.GREEN);
                case "road": return new TileGraphic(Color.DARKGRAY);
                case "swamp": return new TileGraphic(Color.BROWN);
                case "water": return new TileGraphic(Color.BLUE);
                default:
                    System.out.println("Unknown type: " + t + ", defaulting to black");
                    return new TileGraphic(Color.BLACK); // Default color
            }
        });
    }

    public static int getGraphicCount() {
        return graphics.size();
    }
}
