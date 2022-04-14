package com.ventasbackend.repository;

import org.springframework.stereotype.Repository;

import com.ventasbackend.model.Venta;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository 
public interface VentaRepository extends JpaRepository<Venta, Long> {

}
