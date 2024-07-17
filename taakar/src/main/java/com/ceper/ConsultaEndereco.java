package com.ceper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

public class ConsultaEndereco {

    public Endereco buscaEndereco(String cep) throws IOException, InterruptedException {
        String enderecoUrl = "https://viacep.com.br/ws/" + cep + "/json/";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoUrl))
                    .header("accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response to Endereco object
            ObjectMapper objectMapper = new ObjectMapper();
            Endereco endereco = objectMapper.readValue(response.body(), Endereco.class);

            return endereco;
        }catch(UnrecognizedPropertyException e){
            System.out.println("Erro ao desserializar o JSON: Propriedade não reconhecida - " + e.getPropertyName());
            return null;
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na requisição HTTP: " + e.getMessage());
            return null;
        }
    }
}
