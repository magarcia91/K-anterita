package com.ventasbackend.repository;

import org.springframework.stereotype.Repository;

import com.ventasbackend.model.DetalleVenta;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository 
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

}
