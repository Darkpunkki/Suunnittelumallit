package Assignment_1;

import java.util.Random;

class CityMap extends Map {
    private Random random;

    public CityMap(int width, int height) {
        super(width, height);
        this.random = new Random();
        generateMap();  // Now generate the map after random has been initialized
    }

    @Override
    public Tile createTile() {
        int rand = random.nextInt(3);  // Generate a random number between 0 and 2
        switch (rand) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
            default:
                throw new IllegalStateException("Unexpected value: " + rand);
        }
    }
}