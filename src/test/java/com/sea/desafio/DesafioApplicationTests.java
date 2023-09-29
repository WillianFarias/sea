package com.sea.desafio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sea.desafio.entidades.Setor;
import com.sea.desafio.entidades.Trabalhador;
import com.sea.desafio.exception.SetorDuplicadoException;
import com.sea.desafio.exception.TrabalhadorDuplicadoException;
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
	
	@Test
    void testCadastrarTrabalhadorCpfDuplicadoDeveLancarExcecao() {
        String cpf = "11111111111";

        Trabalhador trabalhadorExistente = new Trabalhador();
    
        trabalhadorExistente.setCpf(cpf);

        assertThrows(TrabalhadorDuplicadoException.class, () -> trabalhadorService.cadastrar(trabalhadorExistente));
    }
}
