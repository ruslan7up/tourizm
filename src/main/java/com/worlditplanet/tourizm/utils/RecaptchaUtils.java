package com.worlditplanet.tourizm.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by Admin on 20.01.2018.
 */
public class RecaptchaUtils {
    private static String SECRET_KEY = "6LcBl0EUAAAAAE8pPklXBnvzAjVFAH78S4mHNlN7";
    private static ObjectMapper mapper = new ObjectMapper();
    public static boolean isCaptchaValid(String response) {
        try {
            String url = "https://www.google.com/recaptcha/api/siteverify?"
                    + "secret=" + SECRET_KEY
                    + "&response=" + response;
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            BufferedReader rd = new BufferedReader(new InputStreamReader(client.execute(httpGet).getEntity().getContent(), Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            Map<String, Object> map = mapper.readValue(jsonText, new TypeReference<Map<String, Object>>(){});
            return (boolean) map.get("success");
        } catch (Exception e) {
            return false;
        }
    }
}
