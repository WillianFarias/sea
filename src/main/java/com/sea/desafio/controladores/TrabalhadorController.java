package com.sea.desafio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
