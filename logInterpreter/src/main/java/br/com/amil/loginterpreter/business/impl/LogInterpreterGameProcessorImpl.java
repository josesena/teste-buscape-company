package br.com.amil.loginterpreter.business.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.amil.loginterpreter.business.api.LogInterpreterGameProcessor;
import br.com.amil.loginterpreter.business.api.LogInterpreterRoundProcessor;
import br.com.amil.loginterpreter.model.Game;
import br.com.amil.loginterpreter.model.Player;

public class LogInterpreterGameProcessorImpl extends LogInterpreterGameProcessor {

	@Override
	@SuppressWarnings("resource")
	public Scanner prepareGame(File file) throws FileNotFoundException {
		return new Scanner(file).useDelimiter("\\n");
	}

	@Override
	public List<Game> processGame(Scanner sc) throws ParseException {
		Game game = null;
		List<Game> games = new ArrayList<Game>();
		while(sc.hasNext()) {
			String line = sc.nextLine();
			game = process(line, game, games);			
		}
		return games;
	}
	
	public static Game process(String line, Game game, List<Game> games)
			throws ParseException {
		Pattern patternStart = Pattern.compile(MATCH_STARTED_PATTERN);
		Matcher matcherStart = patternStart.matcher(line);
		
		if (matcherStart.find()) {
			Game newGame = new Game();
			newGame.setName((matcherStart.group(1)));
			games.add(newGame);
			return newGame;
		} else {
			LogInterpreterRoundProcessor logInterpreterRoundProcessor = new LogInterpreterRoundProcessorImpl();
			logInterpreterRoundProcessor.addProcessor(new LogInterpreterKillsProcessor());
			logInterpreterRoundProcessor.addProcessor(new LogInterpreterDeathsProcessor());
			game = logInterpreterRoundProcessor.process(line, game);
		}
		
		return game;
	}

	@Override
	public String outputGames(List<Game> games) {
		StringBuilder sb = new StringBuilder();
		for (Game gameDisplay : games) {
			sb.append("################################################################################");
			sb.append(System.getProperty("line.separator"));
			sb.append("Nome do Jogo: " + gameDisplay.getName());
			sb.append(System.getProperty("line.separator"));
			sb.append("Primeiro do Rank: " + gameDisplay.getPlayerSortedList().get(0).getName());
			sb.append(System.getProperty("line.separator"));
			sb.append("Arma Favorita: " + gameDisplay.getPlayerSortedList().get(0).getFavoriteWeapon());
			sb.append(System.getProperty("line.separator"));
			if(gameDisplay.getPlayerSortedList().get(0).isHighlander()){
				sb.append("Award por nunca morrer!");
				sb.append(System.getProperty("line.separator"));
			}
			sb.append("################################################################################");
			sb.append(System.getProperty("line.separator"));
			sb.append("Rank Completo:");
			sb.append(System.getProperty("line.separator"));
			sb.append("################################################################################");
			sb.append(System.getProperty("line.separator"));
			for (Player player : gameDisplay.getPlayerSortedList()) {
				sb.append("Nome: " + player.getName());
				sb.append(System.getProperty("line.separator"));
				sb.append("Qtd. Kills: " + player.getKillsList().size());
				sb.append(System.getProperty("line.separator"));
				sb.append("Qtd. Deaths: " + player.getDeathsList().size());
				sb.append(System.getProperty("line.separator"));
				sb.append("Arma Favorita: " + player.getFavoriteWeapon());
				sb.append(System.getProperty("line.separator"));
				if(player.isHighlander()){
					sb.append("Award por nunca morrer!");
					sb.append(System.getProperty("line.separator"));
				}
				sb.append("################################################################################");
				sb.append(System.getProperty("line.separator"));
			}
		}
		return sb.toString();
	}

}
