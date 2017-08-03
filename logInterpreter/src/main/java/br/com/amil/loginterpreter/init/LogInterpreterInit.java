package br.com.amil.loginterpreter.init;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import br.com.amil.loginterpreter.business.api.LogInterpreterGameProcessor;
import br.com.amil.loginterpreter.business.impl.LogInterpreterGameProcessorImpl;
import br.com.amil.loginterpreter.model.Game;

public class LogInterpreterInit {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws java.lang.Exception {
		LogInterpreterGameProcessor logInterpreterGameProcessor = new LogInterpreterGameProcessorImpl();
		Scanner sc = logInterpreterGameProcessor.prepareGame(
				new File(LogInterpreterInit.class.getClassLoader().getResource("test.txt").getFile()));
		List<Game> games = logInterpreterGameProcessor.processGame(sc);
		System.out.println(logInterpreterGameProcessor.outputGames(games));
	}
	
}
