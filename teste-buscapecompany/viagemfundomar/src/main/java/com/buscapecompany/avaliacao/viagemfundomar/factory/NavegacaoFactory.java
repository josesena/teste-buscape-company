package com.buscapecompany.avaliacao.viagemfundomar.factory;

import com.buscapecompany.avaliacao.viagemfundomar.enumeration.ComandoEnum;
import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaSubService;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.DescerSubServiceImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.GirarDireitaSubServiceImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.GirarEsquerdaSubServiceImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.MoverSubServiceImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.SubirSubServiceImpl;

public class NavegacaoFactory {

	private static ProcessaSubService getGirarEsquerda = new GirarEsquerdaSubServiceImpl();
	private static ProcessaSubService getGirarDireita  = new GirarDireitaSubServiceImpl();
	private static ProcessaSubService getMoverSubmarino = new MoverSubServiceImpl();
	private static ProcessaSubService getSubirSubmarino = new SubirSubServiceImpl();
	private static ProcessaSubService getDescerSubmarino = new DescerSubServiceImpl();
	
	public static ProcessaSubService getPosicaoSubmarino(ComandoEnum comandoEnum){
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
