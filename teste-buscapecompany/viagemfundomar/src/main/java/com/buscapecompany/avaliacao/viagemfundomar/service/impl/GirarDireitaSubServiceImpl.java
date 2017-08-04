package com.buscapecompany.avaliacao.viagemfundomar.service.impl;

import com.buscapecompany.avaliacao.viagemfundomar.enumeration.DirecaoTransicaoEnum;
import com.buscapecompany.avaliacao.viagemfundomar.model.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaSubService;

public class GirarDireitaSubServiceImpl implements ProcessaSubService{

	@Override
	public void processar(Submarino submarino) {
		DirecaoTransicaoEnum transicao = DirecaoTransicaoEnum.getTransicao(submarino.getDirecao());
		submarino.setDirecao(transicao.getDireita());
	}

}
