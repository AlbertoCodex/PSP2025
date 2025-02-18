package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        // API Key (reemplázala con tu clave)
        String apiKey = "573d47b7";
        String movieTitle = "Inception"; // Película a buscar
        String urlString = "http://www.omdbapi.com/?t=" + movieTitle + "&apikey=" + apiKey;

        try {
            // Crear URL y conexión
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Verificar respuesta HTTP
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Error: HTTP código " + conn.getResponseCode());
            }

            // Leer respuesta
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();
            conn.disconnect();

            // Convertir respuesta a JSON
            JSONObject json = new JSONObject(response.toString());

            // Mostrar JSON completo en consola
            System.out.println("Respuesta JSON:");
            System.out.println(json.toString(4)); // Formateado con sangría de 4 espacios

            // Mostrar algunos datos específicos
            System.out.println("\nTítulo: " + json.getString("Title"));
            System.out.println("Año: " + json.getString("Year"));
            System.out.println("Director: " + json.getString("Director"));
            System.out.println("IMDb Rating: " + json.getString("imdbRating"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
