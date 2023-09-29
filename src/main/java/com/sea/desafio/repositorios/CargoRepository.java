package com.sea.desafio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sea.desafio.entidades.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
