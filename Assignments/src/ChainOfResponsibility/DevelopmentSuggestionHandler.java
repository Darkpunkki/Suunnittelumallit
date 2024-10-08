package ChainOfResponsibility;

class DevelopmentSuggestionHandler extends Handler {
    private Handler nextHandler;

    public DevelopmentSuggestionHandler(String name) {
        super(name);
    }
    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(Message message) {
        if (message.getMessageType() == Message.MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println(name + " is handling development suggestion from " + message.getSenderEmail() + ": " + message.getMessageContent());
            System.out.println("Suggestion logged successfully.");
        } else if (nextHandler != null) {
            System.out.println(name + " cannot handle this message. Passing to the next handler...");
            nextHandler.handleRequest(message);
            System.out.println();
        }
    }

}
