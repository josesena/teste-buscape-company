package com.buscapecompany.avaliacao.viagemfundomar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buscapecompany.avaliacao.viagemfundomar.comando.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaService;

@RestController
public class Controller {
	
	@Autowired
	private ProcessaService exercicioService;
	
	@PostMapping("avaliacaoTeste/{input}")
	public Submarino avaliacaoTeste(@PathVariable(name="input") String input){
		Submarino submarino = exercicioService.processarPosicao(input);
		return submarino;
	}
}
