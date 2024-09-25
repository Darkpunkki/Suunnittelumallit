package Assignment_7;

public class NoviceState extends State {

    public NoviceState(GameCharacter gameCharacter) {
        super(gameCharacter);
    }

    @Override
    public void play() {
        String[] options = {"Choose your action: ", "1. Train, 5. Exit"};
        int choice = getGameCharacter().readUserChoice(options);
        switch (choice) {
            case 1:
                System.out.println("You are training...");
                getGameCharacter().printCurrentState();
                getGameCharacter().addExp(10);
                if (getGameCharacter().getExp() >= 50) {
                    System.out.println("You have reached Intermediate level!");
                    getGameCharacter().setState(new IntermediateState(getGameCharacter()));
                }
                break;

            case 5:
                getGameCharacter().setState(null);
                break;
        }

    }
}
