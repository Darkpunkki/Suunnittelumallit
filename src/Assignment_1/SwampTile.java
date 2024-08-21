package Assignment_1;

class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getType() {
        return "swamp";
    }

    @Override
    public void action() {
        System.out.println("Oops, there is a swamp here...");
    }
}