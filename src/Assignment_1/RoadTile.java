package Assignment_1;

class RoadTile implements Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getType() {
        return "road";
    }

    @Override
    public void action() {
        System.out.println("Driving on the road...");
    }
}

