package com.ventasbackend.repository;

import org.springframework.stereotype.Repository;

import com.ventasbackend.dto.ProductoStockDTO;
import com.ventasbackend.model.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository 
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	@Query(value = "SELECT S.ID_PRODUCTO AS id,\r\n" + 
			"       P.DESCRIPCION AS descripcion,\r\n" + 
			"       P.PRECIO AS precio,\r\n" + 
			"       S.STOCK AS cantidad\r\n" + 
			"FROM\r\n" + 
			"  (SELECT ID_PRODUCTO,\r\n" + 
			"          SUM(CANTIDAD) AS STOCK\r\n" + 
			"   FROM KARDEX\r\n" + 
			"   GROUP BY ID_PRODUCTO\r\n" + 
			"   HAVING SUM(CANTIDAD) > 0) S\r\n" + 
			"INNER JOIN PRODUCTO P ON S.ID_PRODUCTO = P.ID_PRODUCTO", nativeQuery=true)
	List<ProductoStockDTO> productoStock();
    }
