package com.example.tabacariaprojeto.repositories;

import com.example.tabacariaprojeto.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Método para encontrar o carrinho de um cliente específico
    Cart findByClienteId(Long clienteId);
} 