package com.buscapecompany.avaliacao.viagemfundomar.factory;

import com.buscapecompany.avaliacao.viagemfundomar.enumeration.ComandoEnum;
import com.buscapecompany.avaliacao.viagemfundomar.service.PosicaoService;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.DescerSubmarinoImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.GirarDireitaImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.GirarEsquerdaImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.MoverSubmarinoImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.SubirSubmarinoImpl;

public class NavegacaoFactory {

	private static PosicaoService getGirarEsquerda = new GirarEsquerdaImpl();
	private static PosicaoService getGirarDireita  = new GirarDireitaImpl();
	private static PosicaoService getMoverSubmarino = new MoverSubmarinoImpl();
	private static PosicaoService getSubirSubmarino = new SubirSubmarinoImpl();
	private static PosicaoService getDescerSubmarino = new DescerSubmarinoImpl();
	
	public static PosicaoService getPosicaoSubmarino(ComandoEnum comandoEnum){
		switch (comandoEnum) {
		case LEFT: return getGirarEsquerda;
		case RIGHT: return getGirarDireita;
		case MOVE: return getMoverSubmarino;
		case UP: return getSubirSubmarino;
		case DOWN: return getDescerSubmarino;
		default: return null;
		}
	}	
}
