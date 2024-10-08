package ChainOfResponsibility;

import java.util.Random;

class ContactRequestHandler extends Handler {
    private Handler nextHandler;
    private Random random = new Random();

    private String[] departments = { "Sales", "Support", "Billing" };

    public ContactRequestHandler(String name) {
        super(name);
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Message message) {
        if (message.getMessageType() == Message.MessageType.CONTACT_REQUEST) {
            System.out.println(name + " is handling contact request from " + message.getSenderEmail() + ": " + message.getMessageContent());

            // Simulate forwarding to a random department
            String assignedDepartment = departments[random.nextInt(departments.length)];
            System.out.println("Forwarding contact request to the " + assignedDepartment + " department.");
        } else if (nextHandler != null) {
            System.out.println(name + " cannot handle this message. Passing to the next handler...");
            nextHandler.handleRequest(message);
            System.out.println();
        }
    }
}
