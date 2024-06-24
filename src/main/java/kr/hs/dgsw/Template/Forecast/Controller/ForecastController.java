package kr.hs.dgsw.Template.Forecast.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hs.dgsw.Template.Forecast.Enum.Weather;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
@RequestMapping("/forecast")
@Tag(name = "날씨")
public class ForecastController {
    @GetMapping("/get")
    public Weather get() {
        HttpURLConnection urlConnection = null;
        InputStream stream = null;
        String result = "";

        try {
            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=35.8703&longitude=128.5911&current=weather_code");

            urlConnection = (HttpURLConnection) url.openConnection();
            stream = getNetworkConnection(urlConnection);
            result = readStreamToString(stream);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        String weatherCode = "";

        weatherCode = result.substring(result.lastIndexOf("weather_code") + 14, result.lastIndexOf("}") - 1);

        return Weather.getWeather(weatherCode);

    }


    private InputStream getNetworkConnection(HttpURLConnection urlConnection) throws IOException {
        urlConnection.setConnectTimeout(3000);
        urlConnection.setReadTimeout(3000);
        urlConnection.setRequestMethod("GET");
        urlConnection.setDoInput(true);

        if(urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code : " + urlConnection.getResponseCode());
        }

        return urlConnection.getInputStream();
    }

    private String readStreamToString(InputStream stream) throws IOException {
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        String readLine;
        while((readLine = br.readLine()) != null) {
            result.append(readLine + "\n\r");
        }

        br.close();

        return result.toString();
    }
}
