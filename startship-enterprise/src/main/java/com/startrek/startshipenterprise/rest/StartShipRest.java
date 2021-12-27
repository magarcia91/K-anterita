package com.startrek.startshipenterprise.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.startrek.startshipenterprise.service.StartShipService;

@RestController
@RequestMapping("/startship")
public class StartShipRest {
	
	
	@Autowired
	private StartShipService service;
	
	@GetMapping("/resultados")
		public String resultados(@RequestParam("danioA") double danioA,@RequestParam("danioB") double danioB,@RequestParam("danioC") double danioC, @RequestParam("velocidadLuz") double velocidadLuz) {	
		Object obj = service.Flujo(danioA, danioB, danioC, velocidadLuz);	
		return obj.toString();
	}	
}
	
	

	

	
	

