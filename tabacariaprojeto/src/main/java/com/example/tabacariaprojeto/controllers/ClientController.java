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

import com.example.tabacariaprojeto.services.ClientService;
import com.example.tabacariaprojeto.models.Client;
import com.example.tabacariaprojeto.models.Product;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/clients") // Define o caminho base para os endpoints de clientes
public class ClientController {

    @Autowired
    private ClientService clientService; // Injeção do ClientService

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok(clients); // Retorna a lista de clientes com status 200 OK
    }

    // Endpoint para buscar um cliente pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.findById(id);
        return client.map(ResponseEntity::ok) // Retorna o cliente se existir
                     .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 Not Found se não existir
    }

    // Endpoint para criar um novo cliente
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.save(client);
        return ResponseEntity.ok(savedClient); // Retorna o cliente salvo com status 200 OK
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(clientDetails.getName());
            client.setContact(clientDetails.getContact());
            client.setPreferences(clientDetails.getPreferences());
            Client updatedClient = clientService.save(client);
            return ResponseEntity.ok(updatedClient); // Retorna o cliente atualizado com status 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o cliente não existir
        }
    }

    // Endpoint para deletar um cliente pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientService.findById(id).isPresent()) {
            clientService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se o cliente for deletado
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o cliente não existir
        }
    }

    // Endpoint para listar os produtos de um cliente
    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getClientProducts(@PathVariable Long id) {
        Optional<Client> clientOptional = clientService.findById(id);
        if (clientOptional.isPresent()) {
            List<Product> products = clientOptional.get().getPurchasedProducts();
            return ResponseEntity.ok(products); // Retorna a lista de produtos do cliente com status 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o cliente não existir
        }
    }
}