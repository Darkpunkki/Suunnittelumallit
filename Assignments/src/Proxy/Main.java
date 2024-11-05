package Proxy;

public class Main {
    public static void main(String[] args) {
        AccessControlService acs = AccessControlService.getInstance();
        Library library = new Library();

        User admin = new User("admin");
        User user1 = new User("user1");

        System.out.println("\nAdding documents to the library...");

        library.addDocument("public Doc", "This is a public document", false, acs, admin);
        library.addDocument("protected Doc", "This is a protected document", true, acs, admin);

        System.out.println("\n--- Attempting to Access Documents ---");

        // Initial access attempts
        try {
            System.out.println("\nAdminUser accessing public Doc:");
            System.out.println(library.getDocument("public Doc").getContent(admin));

            System.out.println("\nAdminUser accessing protected Doc:");
            System.out.println(library.getDocument("protected Doc").getContent(admin));

            System.out.println("\nUser1 accessing public Doc:");
            System.out.println(library.getDocument("public Doc").getContent(user1));

            System.out.println("\nUser1 attempting to access protected Doc:");
            System.out.println(library.getDocument("protected Doc").getContent(user1));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Granting User1 Access to Protected Document ---");

        // Granting access to User1 for the protected document
        acs.grantAccess("protected Doc", user1.getUsername());

        System.out.println("\nUser1 attempting to access protected Doc after being granted access:");

        // User1 tries to access the protected document again
        try {
            System.out.println(library.getDocument("protected Doc").getContent(user1));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}

