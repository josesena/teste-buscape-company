package com.buscapecompany.avaliacao.viagemfundomar.service.impl;

import com.buscapecompany.avaliacao.viagemfundomar.model.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaSubService;

public class SubirSubServiceImpl implements ProcessaSubService{

	@Override
	public void processar(Submarino submarino) {
		submarino.getPonto().setEixoZ(0);
	}

}
