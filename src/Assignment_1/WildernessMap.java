package Assignment_1;

import java.util.Random;

class WildernessMap extends Map {
    private final Random random;

    public WildernessMap(int width, int height) {
        super(width, height);
        this.random = new Random();  // Initialize the random object
        generateMap();  // Now generate the map after random has been initialized
    }

    @Override
    public Tile createTile() {
        int rand = random.nextInt(3);
        return switch (rand) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> throw new IllegalStateException("Unexpected value: " + rand);
        };
    }
}