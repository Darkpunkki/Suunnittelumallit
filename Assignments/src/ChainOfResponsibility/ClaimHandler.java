package ChainOfResponsibility;

import java.util.Random;

public class ClaimHandler extends Handler {
    private Handler nextHandler;
    private Random random = new Random();

    public ClaimHandler(String name) {
        super(name);
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Message message) {
        if (message.getMessageType() == Message.MessageType.COMPENSATION_CLAIM) {
            System.out.println(name + " is handling compensation claim from " + message.getSenderEmail() + ": " + message.getMessageContent());

            // toss a coin to decide whether to approve or reject the claim
            int result = random.nextInt(101);
            System.out.println("Deciding on a coin toss...");

            if (result < 50) {
                System.out.println("Random number: " + result + " Claim rejected.");
            } else {
                System.out.println("Random number: " + result + " Claim approved.");
            }
            System.out.println();
        } else if (nextHandler != null) {
            System.out.println(name + " cannot handle this message. Passing to the next handler...");
            nextHandler.handleRequest(message);
            System.out.println();
        }
    }
}
