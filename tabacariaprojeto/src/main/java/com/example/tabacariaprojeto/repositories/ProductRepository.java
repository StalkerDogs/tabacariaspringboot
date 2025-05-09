package com.example.tabacariaprojeto.repositories;

import com.example.tabacariaprojeto.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}