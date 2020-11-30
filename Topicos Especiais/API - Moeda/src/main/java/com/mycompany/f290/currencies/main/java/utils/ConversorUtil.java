/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.f290.currencies.main.java.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mycompany.f290.currencies.main.java.model.Moedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorUtil {

    public static void converteReais(double reais) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.hgbrasil.com/finance/quotations?key=a80da7dd"))
                .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.readValue(response.body(), ObjectNode.class);
        String result = node.get("results").get("currencies").toString();
        Moedas moedas = objectMapper.readValue(result, Moedas.class);

        try{
            double euros = reais / moedas.euro.compra;
            double dolars = reais / moedas.dolar.compra;
            double bitcoins = reais / moedas.bitCoin.compra;
            double libras = reais / moedas.libra.compra;
            double pesos = reais / moedas.pesoArgentino.compra;

            System.out.printf("%.2f reais equivale a:\n", reais);
            System.out.printf("\t%.2f Euros \n " +
                    "\t%.2f dolares \n" +
                    "\t%.2f bitcoins \n" +
                    "\t%.2f libras \n" +
                    "\t%.2f Pesos Argentinos\n", euros, dolars, bitcoins, libras, pesos);
        }catch(Exception e){
            System.out.println("Ocorreu um erro ao recuperar os valores: " + e);
        }

    }
}
