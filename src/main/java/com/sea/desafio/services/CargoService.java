package com.sea.desafio.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sea.desafio.dto.CargoDTO;
import com.sea.desafio.entidades.Cargo;
import com.sea.desafio.entidades.Setor;
import com.sea.desafio.repositorios.CargoRepository;
import com.sea.desafio.repositorios.SetorRepository;

@Service
public class CargoService {
	
	@Autowired
	SetorRepository setorRepository;
	
	@Autowired
	CargoRepository cargoRepository;

	@Transactional
	public CargoDTO cadastrar(Cargo cargo, Long setorId) {
	    Setor setor = setorRepository.findById(setorId).get();
	    if (setor == null) {
            throw new NoSuchElementException("Setor nao existe");
        }
	    cargo.getSetor().setId(setorId);
	    return new CargoDTO(cargoRepository.save(cargo));
	}

}
