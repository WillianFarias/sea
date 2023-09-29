package com.sea.desafio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sea.desafio.entidades.Setor;
import com.sea.desafio.exception.SetorDuplicadoException;
import com.sea.desafio.repositorios.SetorRepository;
import com.sea.desafio.services.SetorService;
import com.sea.desafio.services.TrabalhadorService;

@SpringBootTest
class DesafioApplicationTests {

	@Autowired
	TrabalhadorService trabalhadorService;
	
	@Autowired
	SetorRepository setorRepository;
	
	@Autowired
	SetorService setorService;
	
	@Test
	public void testDeveListarTodosTrabalhadores() {
		int quantidadeDeRegistros = trabalhadorService.buscarTodos().size();
		
		Assertions.assertEquals(quantidadeDeRegistros, 6);
	}
	
	@Test
	public void testDeveRetornarExcecaoAoBuscarTrabalhadorPorIdInexistente() {

		assertThrows(NoSuchElementException.class, () -> trabalhadorService.buscarPorId(999L));
	}
	
	@Test
    void testCadastrarSetorNomeDuplicadoDeveLancarExcecao() {
        String nomeSetor = "Setor A";

        Setor setorExistente = new Setor();
        setorExistente.setNome(nomeSetor);

        assertThrows(SetorDuplicadoException.class, () -> setorService.cadastrar(setorExistente));
    }

}
