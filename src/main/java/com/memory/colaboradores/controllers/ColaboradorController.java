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

import com.memory.colaboradores.entities.Colaborador;
import com.memory.colaboradores.repositories.ColaboradorRepository;
import com.memory.colaboradores.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorController {
	@Autowired
	private ColaboradorRepository repository;
	@Autowired
	private ColaboradorService colaboradorService;

	@GetMapping
	public List<Colaborador> findAll() {
		List<Colaborador> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Colaborador findById(@PathVariable Long id) {
		Colaborador result = repository.findById(id).get();
		return result;
	}

	@PostMapping
	public String insert(@RequestBody Colaborador colaborador) {
		try {
			repository.save(colaborador);
			return "Colaborador inserido com sucesso!";
		} catch (Exception e) {
			return "Erro " + e.getMessage();// TODO: handle exception
		}

	}

	@DeleteMapping(value = "deletar/{id}")
	public String delete(@PathVariable Long id) {
		if (!repository.existsById(id)) {
			return "Código não encontrado";
		} else {
			repository.deleteById(id);
			return "Colaborador com o código " + id + " foi deletado com sucesso";
		}
	}

	@PutMapping(value = "atualizar")
	@ResponseBody
	public Colaborador Update(@RequestBody Colaborador colaborador) {
		Colaborador result = repository.saveAndFlush(colaborador);
		return result;
	}

	@GetMapping("/admitidos-no-ano/{ano}")
	public List<Colaborador> listarColaboradoresAdmitidosNoAno(@PathVariable String ano) {
		return colaboradorService.listarColaboradoresPorAno(ano);
	}

}
