package Assignment_1.tiles;

public class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getType() {
        return "building";
    }

    @Override
    public void action() {
        System.out.println("Entering a building...");
    }
}