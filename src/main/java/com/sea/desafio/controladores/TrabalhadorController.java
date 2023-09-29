package com.sea.desafio.controladores;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.desafio.dto.TrabalhadorDTO;
import com.sea.desafio.services.TrabalhadorService;

@RestController
@RequestMapping(value = "/trabalhadores")
public class TrabalhadorController {

	@Autowired
	private TrabalhadorService trabalhadorService;

	@GetMapping
	public List<TrabalhadorDTO> buscarTodos() {
		return trabalhadorService.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TrabalhadorDTO> buscarPorId(@PathVariable Long id) {
	    try {
	        TrabalhadorDTO trabalhador = trabalhadorService.buscarPorId(id);
	        return ResponseEntity.ok(trabalhador);
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.notFound().build();
	    }
	}

}
