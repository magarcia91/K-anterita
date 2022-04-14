package com.ventasbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ventasbackend.model.Cliente;
import com.ventasbackend.repository.ClienteRepository;

@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/api/v1/client")
	public List<Cliente> getClientAll() {
		return clienteRepository.findAll();
	}
	
	@PostMapping("/api/v1/createClient")
	public Cliente createClient(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
