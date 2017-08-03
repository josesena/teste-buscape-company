package com.buscapecompany.avaliacao.viagemfundomar.enumeration;

public enum DirecaoTransicaoEnum {

	NORTE(DirecaoEnum.NORTE, DirecaoEnum.OESTE, DirecaoEnum.LESTE), 
	SUL(DirecaoEnum.SUL,DirecaoEnum.LESTE, DirecaoEnum.OESTE), 
	LESTE(DirecaoEnum.LESTE, DirecaoEnum.NORTE, DirecaoEnum.SUL), 
	OESTE(DirecaoEnum.OESTE, DirecaoEnum.SUL, DirecaoEnum.NORTE);

	private DirecaoEnum atual;
	private DirecaoEnum esquerda;
	private DirecaoEnum direita;

	private DirecaoTransicaoEnum(DirecaoEnum atual, DirecaoEnum esquerda, DirecaoEnum direita) {
		this.atual = atual;
		this.esquerda = esquerda;
		this.direita = direita;
	}
	
	public static DirecaoTransicaoEnum getTransicao(DirecaoEnum direcao){
		for (DirecaoTransicaoEnum dte : values()) {
			if(dte.getAtual().equals(direcao))
				return dte;
		}
		return null;
	}

	public DirecaoEnum getAtual() {
		return atual;
	}

	public void setAtual(DirecaoEnum atual) {
		this.atual = atual;
	}

	public DirecaoEnum getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(DirecaoEnum esquerda) {
		this.esquerda = esquerda;
	}

	public DirecaoEnum getDireita() {
		return direita;
	}

	public void setDireita(DirecaoEnum direita) {
		this.direita = direita;
	}

}
