package com.ceper;

import java.io.FileWriter;
import java.io.IOException;

public class GeraArquivo {

    public void geraJson(Endereco endereco) {
        try {
            String responseBody = endereco.toJson();
            if (responseBody != null) {
                try (FileWriter file = new FileWriter("informacoesCEP.json")) {
                    file.write(responseBody);
                    System.out.println("Arquivo JSON criado com sucesso!");
                } catch (IOException e) {
                    System.out.println("Erro ao criar o arquivo JSON: " + e.getMessage());
                }
            } else {
                System.out.println("Erro ao converter objeto Endereco para JSON.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao converter objeto Endereco para JSON: " + e.getMessage());
        }
    }
}