package br.com.amil.loginterpreter.business.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.amil.loginterpreter.business.LogInterpreterProcessor;
import br.com.amil.loginterpreter.model.Game;
import br.com.amil.loginterpreter.model.Kill;
import br.com.amil.loginterpreter.model.Player;

public class LogInterpreterDeathsProcessor implements LogInterpreterProcessor {

	public Game process(String line, Game game) {
		Player player;
		Pattern patternDead = Pattern.compile(DEAD_PLAYER_PATTERN);
		Matcher matcherDead = patternDead.matcher(line);
		if (matcherDead.find()) {
			if (game.getPlayerList().containsKey(matcherDead.group(1))) {
				player = game.getPlayerList().get(matcherDead.group(1));
			} else {
				player = new Player();
				player.setName(matcherDead.group(1));
				game.addPlayer(player);
			}
			Kill death = new Kill();
			player.getDeathsList().add(death);
		}
		return game;
	}

}
