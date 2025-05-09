package com.example.tabacariaprojeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tabacariaprojeto.models.Cart;
import com.example.tabacariaprojeto.models.Product;
import com.example.tabacariaprojeto.models.Client;
import com.example.tabacariaprojeto.repositories.CartRepository;
import com.example.tabacariaprojeto.repositories.ProductRepository;
import com.example.tabacariaprojeto.repositories.ClientRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Cart getOrCreateCart(Long clienteId) {
        Cart cart = cartRepository.findByClienteId(clienteId);
        if (cart == null) {
            Client cliente = clientRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            cart = new Cart();
            cart.setCliente(cliente);
            cart = cartRepository.save(cart);
        }
        return cart;
    }

    public Cart addProductToCart(Long clienteId, Long produtoId, int quantidade) {
        Cart cart = getOrCreateCart(clienteId);
        Product produto = productRepository.findById(produtoId)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        cart.setProduto(produto);
        cart.setQuantidade(quantidade);
        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(Long clienteId) {
        Cart cart = getOrCreateCart(clienteId);
        cart.setProduto(null);
        cart.setQuantidade(0);
        return cartRepository.save(cart);
    }

    public Cart updateProductQuantity(Long clienteId, int quantidade) {
        Cart cart = getOrCreateCart(clienteId);
        if (cart.getProduto() == null) {
            throw new RuntimeException("Não há produtos no carrinho");
        }
        cart.setQuantidade(quantidade);
        return cartRepository.save(cart);
    }

    public void clearCart(Long clienteId) {
        Cart cart = getOrCreateCart(clienteId);
        cartRepository.delete(cart);
    }
} 