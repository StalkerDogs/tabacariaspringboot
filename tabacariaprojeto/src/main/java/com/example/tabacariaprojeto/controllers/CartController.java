package com.example.tabacariaprojeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tabacariaprojeto.models.Cart;
import com.example.tabacariaprojeto.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long clienteId) {
        Cart cart = cartService.getOrCreateCart(clienteId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{clienteId}/add/{produtoId}")
    public ResponseEntity<Cart> addProductToCart(
            @PathVariable Long clienteId,
            @PathVariable Long produtoId,
            @RequestParam int quantidade) {
        Cart cart = cartService.addProductToCart(clienteId, produtoId, quantidade);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{clienteId}/remove")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long clienteId) {
        Cart cart = cartService.removeProductFromCart(clienteId);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{clienteId}/update")
    public ResponseEntity<Cart> updateProductQuantity(
            @PathVariable Long clienteId,
            @RequestParam int quantidade) {
        Cart cart = cartService.updateProductQuantity(clienteId, quantidade);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{clienteId}/clear")
    public ResponseEntity<Void> clearCart(@PathVariable Long clienteId) {
        cartService.clearCart(clienteId);
        return ResponseEntity.noContent().build();
    }
}
