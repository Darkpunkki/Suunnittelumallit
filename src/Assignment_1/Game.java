package Assignment_1;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        Map map = game.createMap();
        map.display();

        map.tiles[0][0].action();
    }

    public Map createMap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a map type: 1 for CityMap, 2 for WildernessMap");
        int choice = scanner.nextInt();

        return switch (choice) {
            case 1 -> new CityMap(10, 15);
            case 2 -> new WildernessMap(10, 15);
            default -> {
                System.out.println("Invalid choice, defaulting to CityMap.");
                yield new CityMap(5, 5);
            }
        };
    }
}

