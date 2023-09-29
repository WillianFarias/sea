package com.sea.desafio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.desafio.dto.SetorDTO;
import com.sea.desafio.services.SetorService;

@RestController
@RequestMapping(value = "/setores")
public class SetorController {

	@Autowired
	private SetorService setorService;

	@GetMapping
	public List<SetorDTO> buscarTodos() {
		return setorService.buscarTodos();
	}
}
