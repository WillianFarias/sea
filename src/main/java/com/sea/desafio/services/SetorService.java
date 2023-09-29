package com.sea.desafio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sea.desafio.dto.SetorDTO;
import com.sea.desafio.entidades.Setor;
import com.sea.desafio.exception.SetorDuplicadoException;
import com.sea.desafio.repositorios.SetorRepository;

@Service
public class SetorService {

	@Autowired
	SetorRepository setorRepository;
	
	@Transactional(readOnly = true)
	public List<SetorDTO> buscarTodos() {
		return setorRepository.findAll().stream().map(g -> new SetorDTO(g)).collect(Collectors.toList());
	}
	
    @Transactional
    public Setor cadastrar(Setor setor) throws SetorDuplicadoException {
    	Setor setorRegistrado = setorRepository.findByNome(setor.getNome());
        if (setorRegistrado != null) {
            throw new SetorDuplicadoException("Já existe um setor com o nome: " + setor.getNome());
        }
        return setorRepository.save(setor);
    }
    
}
