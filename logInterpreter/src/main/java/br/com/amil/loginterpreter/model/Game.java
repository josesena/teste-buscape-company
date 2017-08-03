package br.com.amil.loginterpreter.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Game {

	private String name = "";
	
	private HashMap<String, Player> playerList = new HashMap<String, Player>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPlayer(Player player) {
		playerList.put(player.getName(), player);
	}
	
	public HashMap<String, Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(HashMap<String, Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Player> getPlayerSortedList() {
		ArrayList<Player> sortedPlayersList = new ArrayList<Player>(playerList.values());
		Collections.sort(sortedPlayersList);
		return sortedPlayersList;
	}
	
}
