package com.ceper;

import com.fasterxml.jackson.databind.ObjectMapper;

public record Endereco(
    String cep,
    String logradouro,
    String complemento, 
    String unidade, 
    String bairro,
    String uf,
    String localidade,
    String ibge,
    String gia,
    String ddd,
    String siafi) {

    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
