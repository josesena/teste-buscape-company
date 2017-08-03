package com.buscapecompany.avaliacao.viagemfundomar.service.impl;

import org.springframework.stereotype.Service;

import com.buscapecompany.avaliacao.viagemfundomar.comando.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.enumeration.ComandoEnum;
import com.buscapecompany.avaliacao.viagemfundomar.factory.NavegacaoFactory;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaService;
import com.buscapecompany.avaliacao.viagemfundomar.service.PosicaoService;

@Service
public class ProcessaServiceImpl implements ProcessaService{

	@Override
	public Submarino processarPosicao(String comandos) {
		Submarino submarino = new Submarino();
		
		String[] comandosArray = comandos.split("");
		for (String comando : comandosArray) {
			ComandoEnum ce = ComandoEnum.getComando(comando);
			PosicaoService posicaoSubmarino = NavegacaoFactory.getPosicaoSubmarino(ce);
			posicaoSubmarino.processar(submarino);
		}
		
		return submarino;
	}
}
