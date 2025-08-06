# REST-API-CLIENT
COMPANY : CODETECH IT SOLUTIONS 
NAME : PURANJAY SARASWAT
INTERN ID : CT04DZ1931
DOMAIN : JAVA PROGRAMMING 
DURATION : 4 WEEKS
MENTOR : NEELA SANTOSH

DESCRIPTION: 
Java Weather Client Program Description (500+ words)
----------------------------------------------------

The provided Java program is a lightweight weather client application that fetches real-time weather data for a specific city using the OpenWeatherMap API. The class `WeatherClient` demonstrates how to perform HTTP GET requests in Java, read API responses, and parse basic JSON data manually without using any external libraries like `org.json` or `Gson`. This makes the program simple and suitable for educational purposes.

### API Configuration

The program begins by declaring three static variables:
1. `API_KEY`: A placeholder API key used to authenticate the request with the OpenWeatherMap server.
2. `CITY`: A variable to define the city for which the weather information is to be fetched. In this case, it's set to “Gwalior”.
3. `UNIT`: The unit in which temperature should be returned, set as `"metric"` for Celsius.

These variables are later used to construct the API URL string.

### HTTP GET Request

In the `main` method, the API URL is constructed by concatenating the city, unit, and API key into a proper HTTP query string. The `URL` class is used to create a connection to the API endpoint. An `HttpURLConnection` object is initialized to open the connection and send an HTTP GET request.

The response code is checked to ensure the request was successful. If the response code is `200` (OK), the program proceeds to read the response using a `BufferedReader`. Each line of the response is appended to a `StringBuilder` to create the full JSON response as a single string.

### Displaying the Response

The raw JSON response is printed to the console for visibility. This is useful for debugging and ensuring that the API is returning the expected structure.

### Parsing JSON Response Manually

Instead of using external JSON parsing libraries, this code performs manual parsing using string operations. The helper method `extract()` is called three times to get the following values from the JSON response:
- `temp`: The current temperature.
- `humidity`: The humidity level.
- `description`: A brief textual description of the weather (e.g., "clear sky").

The `extract()` method works by locating the substring between the provided start key and end delimiter. It uses `indexOf()` and `substring()` methods of the `String` class to extract specific values. If any error occurs during this process, it returns "N/A" as a fallback.

### Output

Once the required values are extracted, the program displays a clean weather report for the given city. It prints temperature, humidity, and weather description using emojis for improved readability and user-friendliness.

### Error Handling

The program includes basic error handling using `try-catch` blocks to ensure that it doesn’t crash if any exceptions occur during the network request, reading stream, or parsing process. Common exceptions that might be caught include `IOException`, `MalformedURLException`, or JSON format issues.

### Educational Value

This code provides an excellent introduction to the following concepts:
- Working with HTTP in Java using `HttpURLConnection`
- Reading input streams
- Basic error handling
- Manual string parsing of JSON data
- Using API services for real-time data integration

While it’s not ideal for production use due to the lack of robust JSON parsing, it’s perfect for students and beginners who want to understand the mechanics of API calls and data extraction in Java.

In real-world applications, JSON parsing should be done using libraries like `Jackson`, `Gson`, or `org.json` for better accuracy and reliability. Nonetheless, this program illustrates the core logic behind how web APIs can be used to build interactive and dynamic console applications in Java.
