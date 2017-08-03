package br.com.amil.loginterpreter.business;

import br.com.amil.loginterpreter.model.Game;

public interface LogInterpreterProcessor {

	String MATCH_STARTED_PATTERN = ".[^-]+- New match (.*.) has started";
	String DEAD_PLAYER_PATTERN = "killed (.*.) [using|by]";
	String KILLER_PLAYER_PATTERN = "\\- (.*.) killed";
	String WEAPON_PATTERN = "(using|by) (.*.)";
	String IGNORED_PLAYER = "<WORLD>";
	
	Game process(String line, Game game);
	
}
