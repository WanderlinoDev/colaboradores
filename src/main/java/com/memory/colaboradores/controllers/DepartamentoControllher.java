package com.memory.colaboradores.controllers;

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

import com.memory.colaboradores.entities.Departamento;
import com.memory.colaboradores.repositories.DepartamentoRepository;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoControllher {
	@Autowired
	private DepartamentoRepository repository;

	@GetMapping("/listar")
	public Iterable<Departamento> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "listar/{id}")
	public Departamento findById(@PathVariable Long id) {
		return repository.findById(id).get();

	}

	@PostMapping("/cadastrar")
	public String insert(@RequestBody Departamento obj) {
		try {
			repository.save(obj);
			return "Departamento inserido com sucesso!";
		} catch (Exception e) {
			return "Erro " + e.getMessage();// TODO: handle exception
		}

	}

	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return "Código não encontrado";
		} else {
			repository.deleteById(id);
			return "Departamento com o código " + id + " foi deletado com sucesso";
		}
	}

	@PutMapping(value = "atualizar")
	@ResponseBody
	public Departamento Update(@RequestBody Departamento obj) {
		return repository.saveAndFlush(obj);
	}
}
