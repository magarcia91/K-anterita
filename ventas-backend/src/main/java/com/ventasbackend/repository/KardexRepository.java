package com.ventasbackend.repository;

import org.springframework.stereotype.Repository;

import com.ventasbackend.model.Kardex;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository 
public interface KardexRepository extends JpaRepository<Kardex, Long> {

}
