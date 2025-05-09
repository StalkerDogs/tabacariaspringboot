package com.example.tabacariaprojeto.repositories;

import com.example.tabacariaprojeto.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

	
}