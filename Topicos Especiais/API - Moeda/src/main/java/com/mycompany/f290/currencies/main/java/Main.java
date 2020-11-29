
package com.mycompany.f290.currencies.main.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mycompany.f290.currencies.main.java.model.Bolsas;
import com.mycompany.f290.currencies.main.java.model.Moedas;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


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
        System.out.println(response.body());
        
        ObjectMapper objectMapper = new ObjectMapper();        
    
        // Crianmos um objeto objectNode para poder capturar um nó especídifo em nosso JSON
        ObjectNode node = objectMapper.readValue(response.body(), ObjectNode.class);
        
        // Seleção do node esecifico currencies com base em nosso modelo de classes
        String result = node.get("results").get("currencies").toString();
        
        
//          Conversão do JSON em objeto do tipo Moedas.
        Moedas moedas = objectMapper.readValue(result, Moedas.class);
        
//        System.out.println("Dollar: "+moedas.dolar.compra);
        
        //  Exibição do toString() do nosso objeto já convertido a partir 
//        System.out.println("Currencies: "+moedas);
        
        //TODO: Agora é sua vez!!!!!

        // VALORES INDIVIDUAIS DE UMA MOEDA


        try{
            System.out.println("Moeda: " + moedas.euro.nome);
            System.out.println("Compra: " + moedas.euro.compra);
            System.out.println("Venda: " + moedas.euro.venda);
            System.out.println("Variação: " + moedas.euro.variacao);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao recuperar os dados da API: " + e );
            // TODOS OS VALORES RETORNAM NULL, ACREDITO QUE A API ESTEJA FORA DO AR
            // Exemplo de retorno: {"currencies":null,"stocks":{"IBOVESPA":{"name":"BM\u0026F BOVESPA","location":"Sao Paulo, Brazil","points":null,"variation":null}
            // Todos os valores são NULL, inclusive pelo link: https://api.hgbrasil.com/finance
        }


        // BOLSAS
        String resultadoBolsas = node.get("results").get("stocks").toString();
        Bolsas bolsas = objectMapper.readValue(resultadoBolsas, Bolsas.class);

        System.out.println("BOLSAS:");
        System.out.println(bolsas.toString());





        /*
            Como os dados já foram convertidos e estão armazenados no objeto moedas; faça as seguintes alterações:
                1. Crie instruções que exibam individualmente algumas das cotações;
                2. Solicite uma entrado de valor em reais para o usuário e faça a converção conforme 
                    a cotação da moeda do dia.                
        */
        
    }
}
