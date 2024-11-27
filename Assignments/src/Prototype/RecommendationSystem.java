package Prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecommendationSystem {
    private List<Recommendation> recommendations;

    public RecommendationSystem() {
        recommendations = new ArrayList<>();
        loadSampleData();
    }

    private void loadSampleData() {
        Book book1 = new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997);
        Book book2 = new Book("J.R.R. Tolkien", "The Hobbit", "Fantasy", 1937);
        Book book3 = new Book("George Orwell", "1984", "Dystopian", 1949);
        Book book4 = new Book("Aldous Huxley", "Brave New World", "Dystopian", 1932);
        Recommendation rec1 = new Recommendation("Young Adults");
        Recommendation rec2 = new Recommendation("Adults");
        rec1.addBook(book1);
        rec1.addBook(book2);
        rec2.addBook(book3);
        rec2.addBook(book4);
        recommendations.add(rec1);
        recommendations.add(rec2);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View Existing Recommendations");
            System.out.println("2. Clone a Recommendation");
            System.out.println("3. Modify a Recommendation");
            System.out.println("4. Create a New Recommendation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewRecommendations();
                    break;
                case "2":
                    cloneRecommendation(scanner);
                    break;
                case "3":
                    modifyRecommendation(scanner);
                    break;
                case "4":
                    createRecommendation(scanner);
                    break;
                case "5":
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void viewRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
            return;
        }
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("\nRecommendation " + (i + 1) + ":");
            System.out.println(recommendations.get(i));
        }
    }

    private void cloneRecommendation(Scanner scanner) {
        System.out.print("Enter the number of the recommendation to clone: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < recommendations.size()) {
            Recommendation clonedRec = recommendations.get(index).clone();
            recommendations.add(clonedRec);
            System.out.println("Recommendation cloned successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private void modifyRecommendation(Scanner scanner) {
        System.out.print("Enter the number of the recommendation to modify: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < recommendations.size()) {
            Recommendation rec = recommendations.get(index);
            while (true) {
                System.out.println("\nModify Recommendation");
                System.out.println("1. Add a Book");
                System.out.println("2. Remove a Book");
                System.out.println("3. Change Target Audience");
                System.out.println("4. View Recommendation");
                System.out.println("5. Back to Main Menu");
                System.out.print("Enter your choice: ");

                String modChoice = scanner.nextLine();

                switch (modChoice) {
                    case "1":
                        addBookToRecommendation(rec, scanner);
                        break;
                    case "2":
                        removeBookFromRecommendation(rec, scanner);
                        break;
                    case "3":
                        changeRecommendationAudience(rec, scanner);
                        break;
                    case "4":
                        System.out.println(rec);
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid index.");
        }
    }

    private void addBookToRecommendation(Recommendation rec, Scanner scanner) {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int publicationYear = Integer.parseInt(scanner.nextLine());
        Book newBook = new Book(author, title, genre, publicationYear);
        rec.addBook(newBook);
        System.out.println("Book added.");
    }

    private void removeBookFromRecommendation(Recommendation rec, Scanner scanner) {
        System.out.print("Enter the title of the book to remove: ");
        String title = scanner.nextLine();
        rec.removeBook(title);
        System.out.println("Book removed if it existed.");
    }

    private void changeRecommendationAudience(Recommendation rec, Scanner scanner) {
        System.out.print("Enter new target audience: ");
        String newAudience = scanner.nextLine();
        rec.changeTargetAudience(newAudience);
        System.out.println("Target audience updated.");
    }

    private void createRecommendation(Scanner scanner) {
        System.out.print("Enter target audience: ");
        String targetAudience = scanner.nextLine();
        Recommendation rec = new Recommendation(targetAudience);
        while (true) {
            System.out.print("Enter author (or 'done' to finish): ");
            String author = scanner.nextLine();
            if (author.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();
            System.out.print("Enter publication year: ");
            int publicationYear = Integer.parseInt(scanner.nextLine());
            Book newBook = new Book(author, title, genre, publicationYear);
            rec.addBook(newBook);
            System.out.println("Book added to the recommendation.");
        }
        recommendations.add(rec);
        System.out.println("New recommendation created.");
    }

    public static void main(String[] args) {
        RecommendationSystem system = new RecommendationSystem();
        system.start();
    }
}
