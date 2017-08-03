package br.com.amil.loginterpreter.business.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import br.com.amil.loginterpreter.model.Game;


public abstract class LogInterpreterGameProcessor {
	
	protected static String MATCH_STARTED_PATTERN = ".[^-]+- New match (.*.) has started";
	public abstract Scanner prepareGame(File file) throws FileNotFoundException;
	public abstract List<Game> processGame(Scanner sc) throws ParseException;
	public abstract String outputGames(List<Game> games);
	
}
