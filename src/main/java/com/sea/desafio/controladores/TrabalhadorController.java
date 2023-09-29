package com.sea.desafio.controladores;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.desafio.dto.TrabalhadorDTO;
import com.sea.desafio.entidades.Setor;
import com.sea.desafio.entidades.Trabalhador;
import com.sea.desafio.services.TrabalhadorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	@ApiOperation("Busca trabalhadores por id")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "Trabalhador não encontrado"),
            @ApiResponse(code = 200, message = "Trabalhador localizado")})
	public ResponseEntity<TrabalhadorDTO> buscarPorId(@PathVariable Long id) {
	    try {
	        TrabalhadorDTO trabalhador = trabalhadorService.buscarPorId(id);
	        return ResponseEntity.ok(trabalhador);
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping
	@ApiOperation("Cria novo setor")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Setor criado com sucesso")})
	public ResponseEntity<Trabalhador> cadastrar(@RequestBody Trabalhador trabalhador) {
		return new ResponseEntity<Trabalhador>(trabalhadorService.cadastrar(trabalhador), HttpStatus.CREATED);
	}

}
