package com.buscapecompany.avaliacao.viagemfundomar.service.impl;

import com.buscapecompany.avaliacao.viagemfundomar.model.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaSubService;

public class MoverSubServiceImpl implements ProcessaSubService {

	@Override
	public void processar(Submarino submarino) {
		ProcessaSubService processaDirecao = submarino.getDirecao().processaDirecao();
		processaDirecao.processar(submarino);
	}

}
