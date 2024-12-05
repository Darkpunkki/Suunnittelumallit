package Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonFacade {

    public String getAttributeValueFromJson(String urlString, String attributePath) throws IllegalArgumentException, IOException {
        String jsonResponse = fetchJsonFromUrl(urlString);
        return extractAttributeFromJson(jsonResponse, attributePath);
    }

    private String fetchJsonFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }

    private String extractAttributeFromJson(String jsonResponse, String attributePath) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);

            String[] keys = attributePath.split("\\."); // Split attributePath by '.'
            Object current = jsonObject;

            for (String key : keys) {
                if (current instanceof JSONObject && ((JSONObject) current).containsKey(key)) {
                    current = ((JSONObject) current).get(key);
                } else {
                    throw new IllegalArgumentException("Attribute path '" + attributePath + "' not found.");
                }
            }

            return current.toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response.", e);
        }
    }
}
