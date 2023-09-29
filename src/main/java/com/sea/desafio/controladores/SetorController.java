package com.sea.desafio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.desafio.dto.SetorDTO;
import com.sea.desafio.entidades.Setor;
import com.sea.desafio.services.SetorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/setores")
public class SetorController {

	@Autowired
	private SetorService setorService;

	@GetMapping
	public List<SetorDTO> buscarTodos() {
		return setorService.buscarTodos();
	}
	
	@PostMapping
	@ApiOperation("Cria novo setor")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Setor criado com sucesso")})
	public ResponseEntity<Setor> cadastrar(@RequestBody Setor setor) {
		return new ResponseEntity<Setor>(setorService.cadastrar(setor), HttpStatus.CREATED);
	}
}
