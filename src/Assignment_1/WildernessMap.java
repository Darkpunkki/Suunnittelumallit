package Assignment_1;

import java.util.Random;

class WildernessMap extends Map {
    private Random random;

    public WildernessMap(int width, int height) {
        super(width, height);
        this.random = new Random();  // Initialize the random object
        generateMap();  // Now generate the map after random has been initialized
    }

    @Override
    public Tile createTile() {
        int rand = random.nextInt(3);  // Generate a random number between 0 and 2
        switch (rand) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new ForestTile();
            default:
                throw new IllegalStateException("Unexpected value: " + rand);
        }
    }
}