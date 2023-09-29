package com.sea.desafio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sea.desafio.dto.TrabalhadorDTO;
import com.sea.desafio.repositorios.TrabalhadorRepository;

@Service
public class TrabalhadorService {
	
	@Autowired
	private TrabalhadorRepository trabalhadorRepository;

	@Transactional(readOnly = true)
	public List<TrabalhadorDTO> buscarTodos() {
		return trabalhadorRepository.findAll().stream().map(g -> new TrabalhadorDTO(g)).collect(Collectors.toList());
	}
}
