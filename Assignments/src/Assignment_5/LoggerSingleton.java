package Assignment_5;


import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class LoggerSingleton {
    private static LoggerSingleton instance;
    private String filename;
    private BufferedWriter writer;

    private LoggerSingleton(String filename) {
        setFileName(filename);
    }

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton("log.txt");
        }
        return instance;
    }

    public void writeToFile(String text) {
        try {
            writer.write(text);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setFileName(String filename) {
        closeFile();
        this.filename = filename;

        try {
            writer = new BufferedWriter(new FileWriter(filename, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        closeFile();
        instance = null;
    }
}
