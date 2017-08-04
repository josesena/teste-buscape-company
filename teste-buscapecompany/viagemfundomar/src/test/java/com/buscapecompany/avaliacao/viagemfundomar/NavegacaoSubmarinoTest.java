package com.buscapecompany.avaliacao.viagemfundomar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.buscapecompany.avaliacao.viagemfundomar.enumeration.DirecaoEnum;
import com.buscapecompany.avaliacao.viagemfundomar.model.Submarino;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.ProcessaPosicaoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class NavegacaoSubmarinoTest {
	
	@InjectMocks
	private ProcessaPosicaoServiceImpl impl;

	@Test
	public void testNegacaoSubmarino() {
		String comandos = "LMRDDMMUU";
		Submarino submarino = new Submarino();
		submarino = impl.processarPosicao(submarino, comandos);

		Assert.assertEquals(submarino.getPonto().getEixoX(), -1);
		Assert.assertEquals(submarino.getPonto().getEixoY(), 2);
		Assert.assertEquals(submarino.getPonto().getEixoZ(), 0);
		Assert.assertEquals(submarino.getDirecao(), DirecaoEnum.NORTE);
		
		imprimirResultado(submarino);
	}

	@Test
	public void testNavegacaoSubmarino2() {
		String comandos = "RMMLMMMDDLL";
		Submarino submarino = new Submarino();
		submarino = impl.processarPosicao(submarino, comandos);

		Assert.assertEquals(submarino.getPonto().getEixoX(), 2);
		Assert.assertEquals(submarino.getPonto().getEixoY(), 3);
		Assert.assertEquals(submarino.getPonto().getEixoZ(), -2);
		Assert.assertEquals(submarino.getDirecao(), DirecaoEnum.SUL);
		
		imprimirResultado(submarino);
	}
	
	
	public void imprimirResultado(Submarino submarino){
		System.out.println("\n------------------------------------------\n" + "Resultado do teste\n"
				+ "------------------------------------------\n" + "[ " + submarino.getPonto().getEixoX() + " "
				+ submarino.getPonto().getEixoY() + " " + submarino.getPonto().getEixoZ() + " "
				+ submarino.getDirecao() + " ]\n \n \n");
	}
}
