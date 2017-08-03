package br.com.amil.loginterpreter.business.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.amil.loginterpreter.business.LogInterpreterProcessor;
import br.com.amil.loginterpreter.model.Game;
import br.com.amil.loginterpreter.model.Kill;
import br.com.amil.loginterpreter.model.Player;

public class LogInterpreterKillsProcessor implements LogInterpreterProcessor {

	public Game process(String line, Game game) {
		Player player;
		Pattern patternKill = Pattern.compile(KILLER_PLAYER_PATTERN);
		Matcher matcherKill = patternKill.matcher(line);
		if (matcherKill.find() && !matcherKill.group(1).equals(IGNORED_PLAYER)) {
			if (game.getPlayerList().containsKey(matcherKill.group(1))) {
				player = game.getPlayerList().get(matcherKill.group(1));
			} else {
				player = new Player();
				player.setName(matcherKill.group(1));
				game.addPlayer(player);
			}
			Kill kill = new Kill();
			Pattern patternWeapon = Pattern.compile(WEAPON_PATTERN);
			Matcher matcherWeapon = patternWeapon.matcher(line);
			if (matcherWeapon.find()) {
				kill.setWeapon(matcherWeapon.group(2));
			}
			player.getKillsList().add(kill);
		}
		return game;
	}

}
