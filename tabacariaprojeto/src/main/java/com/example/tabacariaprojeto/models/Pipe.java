package com.example.tabacariaprojeto.models;

import jakarta.persistence.Entity;

@Entity
public class Pipe extends Product {

    private String material; // Material do cachimbo (madeira, vidro, etc.)
    private String size; // Tamanho do cachimbo

    // Getters e Setters
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}