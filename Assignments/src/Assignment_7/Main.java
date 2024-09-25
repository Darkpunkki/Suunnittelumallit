package Assignment_7;

public class Main {
    public static void main(String[] args) {
        // Initialize game character
        GameCharacter character = new GameCharacter();


        System.out.println("Welcome to the game!");
        System.out.println("Please choose a name for your character:");

        character.setName(character.readUserName());
        System.out.println("Your character's name is " + character.getName());
        character.run();
    }
}
