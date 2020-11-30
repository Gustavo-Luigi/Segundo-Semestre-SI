
package com.mycompany.f290.currencies.main.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mycompany.f290.currencies.main.java.model.Bolsas;
import com.mycompany.f290.currencies.main.java.model.Moedas;
import com.mycompany.f290.currencies.main.java.utils.ConversorUtil;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Criar objeto de gerenciamento
        HttpClient httpClient = HttpClient.newHttpClient();
        
        // Criar uma requisicao Web
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.hgbrasil.com/finance/quotations?key=a80da7dd"))
                .build();
        
       // Recebemos o retorno da requisicao
       var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
       
       // Exibimos os dados recebidos da API HGBrasil
//        System.out.println(response.body());
        
        ObjectMapper objectMapper = new ObjectMapper();        
    
        // Crianmos um objeto objectNode para poder capturar um nó especídifo em nosso JSON
        ObjectNode node = objectMapper.readValue(response.body(), ObjectNode.class);
        
        // Seleção do node esecifico currencies com base em nosso modelo de classes
        String result = node.get("results").get("currencies").toString();
        
        
//      Conversão do JSON em objeto do tipo Moedas.
        Moedas moedas = objectMapper.readValue(result, Moedas.class);
        
//        System.out.println("Dollar: "+moedas.dolar.compra);
        
        //  Exibição do toString() do nosso objeto já convertido a partir 
//        System.out.println("Currencies: "+moedas);
        
        //TODO: Agora é sua vez!!!!!

        // VALORES INDIVIDUAIS DE UMA MOEDA


        // O API ESTAVA CAINDO E RETORANDO VALORES NULL, QUE QUEBRAVAM O PROGRAMA
        // EM ALGUNS MOMENTOS DO DIA FUNCIONAVA NORMALMENTE

        try{
            System.out.println("Moeda: " + moedas.euro.nome);
            System.out.println("Compra: " + moedas.euro.compra);
            System.out.println("Venda: " + moedas.euro.venda);
            System.out.println("Variação: " + moedas.euro.variacao);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao recuperar os dados da API: " + e );
        }


        // BOLSAS
        String resultadoBolsas = node.get("results").get("stocks").toString();
        Bolsas bolsas = objectMapper.readValue(resultadoBolsas, Bolsas.class);

        System.out.println("BOLSAS:");
        System.out.println(bolsas.toString());

        double valor;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor em reais para ser convertido em diversas moedas: ");
        valor = sc.nextDouble();


        ConversorUtil.converteReais(valor);

    }
}
