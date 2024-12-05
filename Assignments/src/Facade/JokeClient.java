package Facade;

import java.io.IOException;

public class JokeClient {
    public static void main(String[] args) {
        JsonFacade jsonFacade = new JsonFacade();
        String apiUrl = "https://api.chucknorris.io/jokes/random";
        String attributeName = "value";

        try {
            String joke = jsonFacade.getAttributeValueFromJson(apiUrl, attributeName);
            System.out.println("Random Chuck Norris Joke: " + joke);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
