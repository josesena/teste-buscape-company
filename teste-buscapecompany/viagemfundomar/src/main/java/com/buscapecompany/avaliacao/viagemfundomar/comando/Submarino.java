package com.buscapecompany.avaliacao.viagemfundomar.comando;

import com.buscapecompany.avaliacao.viagemfundomar.enumeration.DirecaoEnum;
import com.buscapecompany.avaliacao.viagemfundomar.model.Ponto;

public class Submarino {

	private DirecaoEnum direcao;
	private Ponto ponto;
	
	public Submarino(){
		ponto = new Ponto();
		direcao = DirecaoEnum.NORTE;
	}
	
	public Ponto getPonto() {
		return ponto;
	}
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	public DirecaoEnum getDirecao() {
		return direcao;
	}
	public void setDirecao(DirecaoEnum direcao) {
		this.direcao = direcao;
	}
	
	
}
