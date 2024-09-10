package Assignment_5;

public class Main {
    public static void main(String[] args) {
        LoggerSingleton logger = LoggerSingleton.getInstance();

        logger.writeToFile("Hello, world!");
        logger.writeToFile("This is on the second row");

        logger.setFileName("newlog.txt");

        logger.writeToFile("This should be in a new file");
        logger.close();
    }
}
