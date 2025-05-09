package com.example.tabacariaprojeto.models;

import jakarta.persistence.Entity;

@Entity
public class Paper extends Product {

    private String size; // Tamanho da seda
    private int quantity; // Quantidade de sedas no pacote

    // Getters e Setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
