package com.ceper;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um CEP para busca: ");
        String cep = leitura.nextLine();

        if (!cep.matches("\\d{8}")) {//Verifica se tem 8 digitos
            System.out.println("CEP inválido. Certifique-se de que possui 8 dígitos.");
            return;
        }

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .header("accept", "application/json")
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();
        System.out.println(response.body());

        try (FileWriter file = new FileWriter("informacoesCEP.json")) {
            file.write(responseBody);
            System.out.println("Arquivo JSON criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo JSON: " + e.getMessage());
        }
    }
}
