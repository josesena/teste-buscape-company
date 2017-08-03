package br.com.amil.loginterpreter.business.impl;

import br.com.amil.loginterpreter.business.LogInterpreterProcessor;
import br.com.amil.loginterpreter.business.api.LogInterpreterRoundProcessor;
import br.com.amil.loginterpreter.model.Game;

public class LogInterpreterRoundProcessorImpl extends LogInterpreterRoundProcessor {

	@Override
	public void addProcessor(LogInterpreterProcessor processor) {
		this.getProcessorList().add(processor);
	}

	@Override
	public Game process(String line, Game game) {
		for (LogInterpreterProcessor logInterpreterProcessor : this.getProcessorList()) {
			game = logInterpreterProcessor.process(line, game);
		}
		return game;
	}

}
