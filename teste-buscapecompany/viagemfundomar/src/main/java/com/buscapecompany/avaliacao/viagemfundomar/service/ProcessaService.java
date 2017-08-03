package com.buscapecompany.avaliacao.viagemfundomar.service;

import com.buscapecompany.avaliacao.viagemfundomar.comando.Submarino;

public interface ProcessaService {

	public Submarino processarPosicao(String comandos);
	
}
