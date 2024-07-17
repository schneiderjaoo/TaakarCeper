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
        
        ConsultaEndereco consulta = new ConsultaEndereco();
        Endereco novoEndereco = consulta.buscaEndereco("1");
        System.out.println(novoEndereco);
        // String responseBody = response.body();
        // System.out.println(response.body());
        // //try tente
        // try (FileWriter file = new FileWriter("informacoesCEP.json")) {//nome do arquivo gerado
        //     file.write(responseBody);
        //     System.out.println("Arquivo JSON criado com sucesso!");
        // //se não deu pegue a exceção 
        // } catch (IOException e) {//Interrupção
        //     System.out.println("Erro ao criar o arquivo JSON: " + e.getMessage());
        // }
    }
}
