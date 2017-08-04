package com.buscapecompany.avaliacao.viagemfundomar.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buscapecompany.avaliacao.viagemfundomar.model.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaPosicaoService;

@RestController
public class Controller {

	@Autowired
	private ProcessaPosicaoService processaService;

	@PostMapping("avaliacaoTeste/{comando}")
	public Submarino avaliacaoTeste(@PathVariable(name = "comando") String comando) {
		Submarino submarino = new Submarino();
		Pattern pattern = Pattern.compile("^\\w[LRMDUlrmdu]*$");
		Matcher matcher = pattern.matcher(comando);
		if (matcher.find()) {
			 submarino = processaService.processarPosicao(submarino, comando);
			if (submarino.getPonto().getEixoZ() == 0)
				submarino.setMensagem("Superfície do oceano");
			return submarino;
		} else {
			submarino.setMensagem("Comando inválido ! Comandos válidos: LRMDUlrmdu");
			return submarino;
		}
	}
}
