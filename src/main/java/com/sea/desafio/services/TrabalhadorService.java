package com.sea.desafio.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sea.desafio.dto.TrabalhadorDTO;
import com.sea.desafio.entidades.Trabalhador;
import com.sea.desafio.exception.SetorDuplicadoException;
import com.sea.desafio.exception.TrabalhadorDuplicadoException;
import com.sea.desafio.repositorios.TrabalhadorRepository;

@Service
public class TrabalhadorService {
	
	@Autowired
	private TrabalhadorRepository trabalhadorRepository;

	@Transactional(readOnly = true)
	public List<TrabalhadorDTO> buscarTodos() {
		return trabalhadorRepository.findAll().stream().map(g -> new TrabalhadorDTO(g)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public TrabalhadorDTO buscarPorId(Long id) throws NoSuchElementException {
	    Trabalhador trabalhador = trabalhadorRepository.findById(id)
	            .orElseThrow(() -> new NoSuchElementException("Trabalhador não encontrado com o ID: " + id));

	    return new TrabalhadorDTO(trabalhador);
	}
	
	 @Transactional
	    public Trabalhador cadastrar(Trabalhador trabalhador) throws SetorDuplicadoException {
	    	Trabalhador trabalhadorRegistrado = trabalhadorRepository.findByCpf(trabalhador.getCpf());
	        if (trabalhadorRegistrado != null) {
	            throw new TrabalhadorDuplicadoException("Já existe um trabalhador com o cpf: " + trabalhador.getCpf());
	        }
	        return trabalhadorRepository.save(trabalhador);
	    }
}
