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

        /* Neste caso, estamos configurando que a propriedade "source" do JSON deverá ser convertida para o atributo "fonte",
            fiz esta alteração para fazer mais sentido o uso de anotações do Jackson.
            Com as anotações neste caso, podemos utilizar qualquer nome de classe e atributo, sem esta anotação o atributo
            da classe deve ter o mesmo nome do atributo JSON para que a conversão possa ser realizada.
        */
        @JsonProperty("source")
        public String fonte;

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
            return "Bolsas{" + " Fonte= " + fonte + " IBOVESPA= " + ibovespa + ", NASDAQ= " + nasdaq + ", CAC= " + cac + ", NIKKEI= " + nikkei +  '}';
        }

}
