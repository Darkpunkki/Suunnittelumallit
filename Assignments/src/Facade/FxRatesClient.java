package Facade;

import java.io.IOException;

public class FxRatesClient {
    public static void main(String[] args) {
        JsonFacade jsonFacade = new JsonFacade();
        String apiUrl = "https://api.fxratesapi.com/latest";

        try {
            // Fetch the base currency
            String baseCurrency = jsonFacade.getAttributeValueFromJson(apiUrl, "base");
            System.out.println("Base Currency: " + baseCurrency);

            // Fetch a specific rate (e.g., USD)
            String eurRate = jsonFacade.getAttributeValueFromJson(apiUrl, "rates.EUR");
            System.out.println("EUR Exchange Rate: " + eurRate);

            String yenRate = jsonFacade.getAttributeValueFromJson(apiUrl, "rates.JPY");
            System.out.println("JPY Exchange Rate: " + yenRate);

        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
