package com.buscapecompany.avaliacao.viagemfundomar.service.impl;

import org.springframework.stereotype.Service;

import com.buscapecompany.avaliacao.viagemfundomar.enumeration.ComandoEnum;
import com.buscapecompany.avaliacao.viagemfundomar.factory.NavegacaoFactory;
import com.buscapecompany.avaliacao.viagemfundomar.model.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaPosicaoService;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaSubService;

@Service
public class ProcessaPosicaoServiceImpl implements ProcessaPosicaoService{

	@Override
	public Submarino processarPosicao(Submarino submarino, String comandos) {
		
		String[] comandosArray = comandos.split("");
		for (String comando : comandosArray) {
			ComandoEnum ce = ComandoEnum.getComando(comando);
			ProcessaSubService posicaoSubmarino = NavegacaoFactory.getPosicaoSubmarino(ce);
			posicaoSubmarino.processar(submarino);
		}
		
		return submarino;
	}
}
