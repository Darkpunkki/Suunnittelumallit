package Assignment_7;

import java.util.Scanner;

public class GameCharacter {
    private static Scanner scanner = new Scanner(System.in);
    private State state;
    private double exp = 0;
    private String level = "Novice";
    private String name;
    private double health = 100;

    public GameCharacter() {
        state = new NoviceState(this);
    }

    public void run() {
        while (true) {
            if (state == null) {
                System.out.println("Game over!");
                return;
            }
            state.play();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void printCurrentState() {
        System.out.println("Current level: " + getLevel());
    }

    public void addExp(double amount) {
        exp += amount;
        System.out.println("You gained " + amount + " exp.");
        System.out.println("Your exp is now " + getExp());
    }

    public double getExp() {
        return exp;
    }

    public void addHealth(double amount) {
        health += amount;
        System.out.println("You gained " + amount + " health.");
        System.out.println("Your health is now " + getHealth());
    }

    public void reduceHealth(double amount) {
        health -= amount;
        System.out.println("You lost " + amount + " health.");
        System.out.println("Your health is now " + getHealth());
    }

    public double getHealth() {
        return health;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int readUserChoice(String[] options) {
        // print options
        System.out.println("\nSelect an option:");
        for (String option : options) {
            System.out.println(option);
        }
        // read user input
        return scanner.nextInt();
    }

    public String readUserName() {
        return scanner.next();
    }
}
