package br.com.amil.loginterpreter.business.api;

import java.util.ArrayList;
import java.util.List;

import br.com.amil.loginterpreter.business.LogInterpreterProcessor;
import br.com.amil.loginterpreter.model.Game;


public abstract class LogInterpreterRoundProcessor {

	List<LogInterpreterProcessor> processorList = new ArrayList<LogInterpreterProcessor>();
	public abstract void addProcessor(LogInterpreterProcessor processor);
	public abstract Game process(String line, Game game);
	
	public List<LogInterpreterProcessor> getProcessorList() {
		return processorList;
	}
	public void setProcessorList(List<LogInterpreterProcessor> processorList) {
		this.processorList = processorList;
	}
	
}
