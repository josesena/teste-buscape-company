package com.buscapecompany.avaliacao.viagemfundomar.service.impl;

import com.buscapecompany.avaliacao.viagemfundomar.model.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaSubService;

public class NorteSubServiceImpl implements ProcessaSubService{

	@Override
	public void processar(Submarino submarino) {
		submarino.getPonto().setEixoY(submarino.getPonto().getEixoY() + 1);
	}

}
