package com.sea.desafio.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sea.desafio.services.TrabalhadorService;

@SpringBootTest
class TrabalhadorServiceTest {

	@Autowired
	TrabalhadorService trabalhadorService;
	
	@Test
	public void deveListarTodosTrabalhadores() {
		int quantidadeDeRegistros = trabalhadorService.buscarTodos().size();
		
		Assertions.assertEquals(quantidadeDeRegistros, 6);
	}
}
