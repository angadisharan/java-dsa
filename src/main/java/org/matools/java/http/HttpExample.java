package org.matools.java.http;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HttpExample {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://matools.org");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int status = conn.getResponseCode();
        System.out.println("Status: " + status);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        conn.disconnect();
    }
}