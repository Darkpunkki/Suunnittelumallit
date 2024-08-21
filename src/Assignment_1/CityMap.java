package Assignment_1;

import java.util.Random;

class CityMap extends Map {
    private final Random random;

    public CityMap(int width, int height) {
        super(width, height);
        this.random = new Random();
        generateMap();
    }

    @Override
    public Tile createTile() {
        int rand = random.nextInt(3);
        return switch (rand) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            case 2 -> new BuildingTile();
            default -> throw new IllegalStateException("Unexpected value: " + rand);
        };
    }
}