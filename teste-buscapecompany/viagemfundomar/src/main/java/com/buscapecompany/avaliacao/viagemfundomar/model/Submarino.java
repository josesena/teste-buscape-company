package com.buscapecompany.avaliacao.viagemfundomar.model;

import com.buscapecompany.avaliacao.viagemfundomar.enumeration.DirecaoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Submarino {

	private DirecaoEnum direcao;
	private Ponto ponto;
	private String mensagem;

	public Submarino() {
		ponto = new Ponto();
		direcao = DirecaoEnum.NORTE;
	}

	public Ponto getPonto() {
		return ponto;
	}

	@JsonInclude(Include.NON_NULL)
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
