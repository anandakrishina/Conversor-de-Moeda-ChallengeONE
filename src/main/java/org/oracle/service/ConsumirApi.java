package org.oracle.service;

import com.google.gson.Gson;
import org.oracle.model.Moeda;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirApi {
    final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
    final String API_KEY = "0b0182f98cccf374b809ddd8";
    public Moeda obterDados(String moeda) {
        String endereco = ENDERECO+API_KEY+"/latest/"+moeda;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());

            return new Gson().fromJson(response.body(), Moeda.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
