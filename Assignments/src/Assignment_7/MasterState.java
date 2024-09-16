package Assignment_7;

public class MasterState extends State {
    public MasterState(GameCharacter gameCharacter) {
        super(gameCharacter);
        gameCharacter.setLevel("Master");
    }

    public void play() {
        System.out.println("You are a master now!");
        getGameCharacter().setState(null);
    }

}
