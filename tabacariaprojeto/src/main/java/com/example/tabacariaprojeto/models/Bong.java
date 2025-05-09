package com.example.tabacariaprojeto.models;

import jakarta.persistence.Entity;

@Entity
public class Bong extends Product {

    private String material; // Material do bong (vidro, silicone, etc.)
    private String size; // Tamanho do bong
    private boolean hasPercolator; // Se o bong tem percolador

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

    public boolean isHasPercolator() {
        return hasPercolator;
    }

    public void setHasPercolator(boolean hasPercolator) {
        this.hasPercolator = hasPercolator;
    }
}