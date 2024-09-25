package Assignment_7;

public class ExpertState extends State {

        public ExpertState(GameCharacter gameCharacter) {
            super(gameCharacter);
            gameCharacter.setLevel("Expert");
        }

        public void play() {
            String[] options = {"Choose your action: ", "1. Train, 2. Meditate, 3. Fight, 5. Exit"};
            int choice = getGameCharacter().readUserChoice(options);
            switch (choice) {
                case 1:
                    System.out.println("You are training...");
                    getGameCharacter().printCurrentState();
                    getGameCharacter().addExp(10);
                    break;

                case 2:
                    System.out.println("You are meditating...");
                    getGameCharacter().addHealth(20);
                    getGameCharacter().printCurrentState();
                    break;

                case 3:
                    System.out.println("You are fighting...");
                    getGameCharacter().printCurrentState();
                    getGameCharacter().addExp(20);
                    getGameCharacter().reduceHealth(50);
                    if (getGameCharacter().getHealth() <= 0) {
                        System.out.println("You have died...");
                        getGameCharacter().setState(null);
                        return;
                    }
                    break;

                case 5:
                    getGameCharacter().setState(null);
                    return;
            }


            if (getGameCharacter().getExp() >= 150) {
                System.out.println("Leveling up to Master...");
                getGameCharacter().setState(new MasterState(getGameCharacter()));
            }

        }
}
