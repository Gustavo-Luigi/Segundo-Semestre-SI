package com.mycompany.f290.currencies.main.java.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.f290.currencies.main.java.model.stocks.Cac;
import com.mycompany.f290.currencies.main.java.model.stocks.Ibovespa;
import com.mycompany.f290.currencies.main.java.model.stocks.Nasdaq;
import com.mycompany.f290.currencies.main.java.model.stocks.Nikkei;

/*
As anotações do Jackson são utilizadas para proverem funcionalidades extras com minimo esforço
Neste caso estamos informando que atributos não declarados na classe devem ser ignorados.
*/
@JsonIgnoreProperties(ignoreUnknown = true)

public class Bolsas {

        @JsonProperty("IBOVESPA")
        public Ibovespa ibovespa;

        @JsonProperty("NASDAQ")
        public Nasdaq nasdaq;

        @JsonProperty("CAC")
        public Cac cac;

        @JsonProperty("NIKKEI")
        public Nikkei nikkei;

        @Override
        public String toString() {
            return "Bolsas{" + " IBOVESPA= " + ibovespa + ", NASDAQ= " + nasdaq + ", CAC= " + cac + ", NIKKEI= " + nikkei +  '}';
        }

}
