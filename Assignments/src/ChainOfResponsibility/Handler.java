package ChainOfResponsibility;

public class Handler {

    private Handler nextHandler;
    protected String name;

    public Handler(String name) {
        this.name = name;
    }

    public void handleRequest(Message message) {
        if (nextHandler != null) {
            nextHandler.handleRequest(message);
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }
}
