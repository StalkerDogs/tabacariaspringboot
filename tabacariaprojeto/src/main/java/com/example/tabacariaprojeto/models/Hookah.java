package com.example.tabacariaprojeto.models;

import jakarta.persistence.Entity;

@Entity
public class Hookah extends Product {

    private int hoses; // Número de mangueiras
    private String material; // Material do narguilé (vidro, metal, etc.)

    // Getters e Setters
    public int getHoses() {
        return hoses;
    }

    public void setHoses(int hoses) {
        this.hoses = hoses;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}