package com.sea.desafio.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sea.desafio.dto.CargoDTO;
import com.sea.desafio.entidades.Cargo;
import com.sea.desafio.services.CargoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/cargos")
public class CargoController {
	
	@Autowired
	CargoService cargoService;
	
	@PostMapping
	@ApiOperation("Cria novo cargo")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Cargo criado com sucesso")})
	public ResponseEntity<CargoDTO> cadastrar(@RequestBody Map<String, Object> cargoData) {
	    Long setorId = ((Number) cargoData.get("setorId")).longValue();
	    Cargo cargo = new Cargo();
	    cargo.setNome((String) cargoData.get("nome"));

	    return new ResponseEntity<CargoDTO>(cargoService.cadastrar(cargo, setorId), HttpStatus.CREATED);
	}


}
