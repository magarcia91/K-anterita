package com.ventasbackend.repository;

import org.springframework.stereotype.Repository;

import com.ventasbackend.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
