package me.itsnathang.placeholders;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;

public class LocationInfo {
    private JSONObject data;

    LocationInfo(InetSocketAddress address) {
        String ip = address.getAddress().getHostAddress();

        try {
            this.data = getJSON(ip);
        } catch (Exception e) { this.data = null; }
    }

    private JSONObject getJSON(String ip) throws Exception {
        StringBuilder response = new StringBuilder();

        URL url = new URL("http://ip-api.com/json/" + ip);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = rd.readLine()) != null) {
            response.append(line);
        }

        rd.close();

        return (JSONObject) new JSONParser().parse(response.toString());
    }

    public String getData(String key) {
        if (data == null) return "API Down";
        return data.containsKey(key) ? data.get(key).toString() : "invalid identifier";
    }

    public boolean isValid() {
        return data != null;
    }
}
