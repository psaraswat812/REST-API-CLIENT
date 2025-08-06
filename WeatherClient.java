// package JavaTasks.Task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherClient {

    static String API_KEY = "c75462a085e5b429dafb09e949cb8c16";  
    static String CITY = "Gwalior"; // You can change to any city
    static String UNIT = "metric";

    public static void main(String[] args) {
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" 
                + CITY + "&units=" + UNIT + "&appid=" + API_KEY;

            URL url = new URL(urlString);  // <== This will show warning, but it's okay
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
                );
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Show raw response just to be safe
                System.out.println("🌐 Full API Response:\n" + response.toString());

                // Extract manually
                String json = response.toString();
                String temp = extract(json, "\"temp\":", ",");
                String humidity = extract(json, "\"humidity\":", "}");
                String description = extract(json, "\"description\":\"", "\"");

                System.out.println("\n🌦️ Weather Report for " + CITY + ":");
                System.out.println("Temperature: " + temp + "°C");
                System.out.println("Humidity: " + humidity + "%");
                System.out.println("Description: " + description);
            } else {
                System.out.println("❌ Failed to fetch data. HTTP code: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public static String extract(String json, String keyStart, String endDelimiter) {
        try {
            int start = json.indexOf(keyStart) + keyStart.length();
            int end = json.indexOf(endDelimiter, start);
            return json.substring(start, end);
        } catch (Exception e) {
            return "N/A";
        }
    }
}
