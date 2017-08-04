package com.buscapecompany.avaliacao.viagemfundomar.service;

import com.buscapecompany.avaliacao.viagemfundomar.model.Submarino;

public interface ProcessaPosicaoService {

	public Submarino processarPosicao(Submarino submarino, String comandos);
	
}
