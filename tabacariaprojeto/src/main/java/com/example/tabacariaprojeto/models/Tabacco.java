package com.example.tabacariaprojeto.models;

import jakarta.persistence.Entity;

@Entity
public class Tabacco extends Product {

    private String origin; // "Importado" ou "Nacional"
    private String flavor; // Sabor do tabaco

    // Getters e Setters
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}