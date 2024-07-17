package com.ceper;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cep = "";
        boolean termina = false;
        Scanner sc = new Scanner(System.in);

        while (!termina) {
            System.out.println("Digite seu cep:");
            cep = sc.nextLine();

            if (cep.length() == 8) {
                try {
                    ConsultaEndereco consulta = new ConsultaEndereco();
                    Endereco novoEndereco = consulta.buscaEndereco(cep);
                    GeraArquivo gerar = new GeraArquivo();
                    gerar.geraJson(novoEndereco);
                    System.out.println(novoEndereco);
                    termina = true;
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("Finalizando a sessão");
                }
            } else {
                System.out.println("O cep precisa ter 8 caracteres");
            }
        }
        sc.close();
    }
}
