package com.buscapecompany.avaliacao.viagemfundomar.enumeration;

public enum ComandoEnum {

	LEFT("L"),
	RIGHT("R"),
	MOVE("M"),
	UP("U"),
	DOWN("D");
	
	public String posicao;
	
	ComandoEnum(String valor ){
		posicao = valor;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	public static ComandoEnum getComando(String comando) {
		for (ComandoEnum cmd : values()) {
			if (cmd.getPosicao().equalsIgnoreCase(comando)) {
				return cmd;
			}
		}
		return null;
	}
	
	
}
