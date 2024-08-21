package Assignment_1;

class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "forest";
    }

    @Override
    public void action() {
        System.out.println("Going to the forest...");
    }
}