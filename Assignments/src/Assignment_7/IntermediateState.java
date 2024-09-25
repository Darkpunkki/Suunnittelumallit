package Assignment_7;

public class IntermediateState extends State {
    public IntermediateState(GameCharacter gameCharacter) {
        super(gameCharacter);
        gameCharacter.setLevel("Intermediate");
    }


    public void play() {
        String[] options = {"Choose your action: ", "1. Train, 2. Meditate, 5. Exit"};
        int choice = getGameCharacter().readUserChoice(options);
        switch (choice) {
            case 1:
                System.out.println("You are training...");
                getGameCharacter().printCurrentState();
                getGameCharacter().addExp(10);
                if (getGameCharacter().getExp() >= 100) {
                    System.out.println("You have reached Expert level!");
                    getGameCharacter().setState(new ExpertState(getGameCharacter()));
                }
                break;

            case 2:
                System.out.println("You are meditating...");
                getGameCharacter().addHealth(20);
                getGameCharacter().printCurrentState();
                break;

            case 5:
                getGameCharacter().setState(null);
                break;
        }
    }

}
