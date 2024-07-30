package com.memory.colaboradores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memory.colaboradores.entities.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
