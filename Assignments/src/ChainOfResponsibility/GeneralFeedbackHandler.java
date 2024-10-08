package ChainOfResponsibility;

class GeneralFeedbackHandler extends Handler {
    private Handler nextHandler;

    public GeneralFeedbackHandler(String name) {
        super(name);
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Message message) {
        if (message.getMessageType() == Message.MessageType.GENERAL_FEEDBACK) {
            System.out.println(name + " is handling general feedback from " + message.getSenderEmail() + ": " + message.getMessageContent());
            System.out.println("Thank you for your feedback! We value your input and will consider it.");
        } else if (nextHandler != null) {
            System.out.println(name + " cannot handle this message. Passing to the next handler...");
            nextHandler.handleRequest(message);
            System.out.println();
        }
    }
}
