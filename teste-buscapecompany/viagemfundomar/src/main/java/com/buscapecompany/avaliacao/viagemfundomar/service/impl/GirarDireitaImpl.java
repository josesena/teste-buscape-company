package com.buscapecompany.avaliacao.viagemfundomar.service.impl;

import com.buscapecompany.avaliacao.viagemfundomar.comando.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.enumeration.DirecaoTransicaoEnum;
import com.buscapecompany.avaliacao.viagemfundomar.service.PosicaoService;

public class GirarDireitaImpl implements PosicaoService{

	@Override
	public void processar(Submarino submarino) {
		DirecaoTransicaoEnum transicao = DirecaoTransicaoEnum.getTransicao(submarino.getDirecao());
		submarino.setDirecao(transicao.getDireita());
	}

}
