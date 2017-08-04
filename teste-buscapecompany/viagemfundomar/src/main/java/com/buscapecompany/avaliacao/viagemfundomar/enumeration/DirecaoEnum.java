package com.buscapecompany.avaliacao.viagemfundomar.enumeration;

import com.buscapecompany.avaliacao.viagemfundomar.service.ProcessaSubService;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.LesteSubServiceImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.NorteSubServiceImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.OesteSubServiceImpl;
import com.buscapecompany.avaliacao.viagemfundomar.service.impl.SulSubServiceImpl;

public enum DirecaoEnum {

	NORTE {
		@Override
		public ProcessaSubService processaDirecao() {
			return new NorteSubServiceImpl();
		}
	}, 
	SUL {
		@Override
		public ProcessaSubService processaDirecao() {
			return new SulSubServiceImpl();
		}
	}, 
	LESTE {
		@Override
		public ProcessaSubService processaDirecao() {
			return new LesteSubServiceImpl();
		}
	}, 
	OESTE {
		@Override
		public ProcessaSubService processaDirecao() {
			return new OesteSubServiceImpl();
		}
	};
	
	public abstract ProcessaSubService processaDirecao();
}
