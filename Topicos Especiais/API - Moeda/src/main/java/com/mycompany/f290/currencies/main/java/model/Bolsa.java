package com.mycompany.f290.currencies.main.java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bolsa {

    @JsonProperty("name")
    public String nome;

    @JsonProperty("location")
    public String local;

    @JsonProperty("points")
    public Double pontos;

    @JsonProperty("variation")
    public Double variacao;

    @Override
    public String toString() {
        return "Bolsa{" + "nome=" + nome + ", local=" + local + ", pontos=" + pontos + ", variação=" + variacao + '}';
    }

}
