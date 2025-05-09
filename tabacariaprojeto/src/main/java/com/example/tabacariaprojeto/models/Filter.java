package com.example.tabacariaprojeto.models;

import jakarta.persistence.Entity;

@Entity
public class Filter extends Product {

    private String material; // Material da piteira (papel, plástico, etc.)
    private int quantity; // Quantidade de piteiras no pacote

    // Getters e Setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}