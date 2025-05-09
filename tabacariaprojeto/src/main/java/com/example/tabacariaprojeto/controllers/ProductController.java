package com.example.tabacariaprojeto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tabacariaprojeto.models.Product;
import com.example.tabacariaprojeto.services.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/products") // Define o caminho base para os endpoints de produtos
public class ProductController {

    @Autowired
    private ProductService productService; // Injeção do ProductService

    // Endpoint para listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products); // Retorna a lista de produtos com status 200 OK
    }

    // Endpoint para buscar um produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(ResponseEntity::ok) // Retorna o produto se existir
                      .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 Not Found se não existir
    }

    // Endpoint para criar um novo produto
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(savedProduct); // Retorna o produto salvo com status 200 OK
    }

    // Endpoint para atualizar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            Product updatedProduct = productService.save(product);
            return ResponseEntity.ok(updatedProduct); // Retorna o produto atualizado com status 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o produto não existir
        }
    }

    // Endpoint para deletar um produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.findById(id).isPresent()) {
            productService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se o produto for deletado
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o produto não existir
        }
    }

    // Endpoint para listar produtos de um cliente específico
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Product>> getProductsByClient(@PathVariable Long clientId) {
        List<Product> products = productService.findByClientId(clientId);
        return ResponseEntity.ok(products); // Retorna a lista de produtos do cliente com status 200 OK
    }
}
