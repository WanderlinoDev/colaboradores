package com.memory.colaboradores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.memory.colaboradores.entities.Cargo;
import com.memory.colaboradores.repositories.CargoRepository;

@RestController
@RequestMapping(value = "/cargos")
public class CargoController {
	@Autowired
	private CargoRepository repository;

	@GetMapping
	public List<Cargo> findAll() {
		List<Cargo> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Cargo findById(@PathVariable Long id) {
		Cargo result = repository.findById(id).get();
		return result;
	}

	@PostMapping
	public Cargo insert(@RequestBody Cargo cargo) {
		Cargo result = repository.save(cargo);
		return result;
	}

	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return "Código não encontrado";
		} else {
			repository.deleteById(id);
			return "Cargo com o código " + id + " foi deletado com sucesso";
		}
	}
	
	@PutMapping (value ="atualizar" )
	@ResponseBody
	public Cargo Update(@RequestBody Cargo cargo) {
		Cargo result = repository.saveAndFlush(cargo);
		return result;
	}

}
