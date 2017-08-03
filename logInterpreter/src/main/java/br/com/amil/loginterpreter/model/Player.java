package br.com.amil.loginterpreter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements Comparable<Player> {

	private String name;
	
	private List<Kill> killsList = new ArrayList<Kill>();
	
	private List<Kill> deathsList = new ArrayList<Kill>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Kill> getKillsList() {
		return killsList;
	}

	public void setKillsList(List<Kill> killsList) {
		this.killsList = killsList;
	}

	public List<Kill> getDeathsList() {
		return deathsList;
	}

	public void setDeathsList(List<Kill> deathsList) {
		this.deathsList = deathsList;
	}
	
	public String getFavoriteWeapon() {
		List<String> weaponList = new ArrayList<String>();
		for (Kill m : this.killsList) {
			weaponList.add(m.getWeapon());
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < weaponList.size(); i++) {
			Integer count = map.get(weaponList.get(i));
			map.put(weaponList.get(i), count == null ? 1 : count + 1);
		}
		Integer quantity = 0;
		String weapon = "";
		for (String key : map.keySet()) {
			if(map.get(key) > quantity){
				quantity = map.get(key);
				weapon = key;
			}
		}
		return weapon;
	}
	
	public Boolean isHighlander(){
		return this.deathsList.isEmpty();
	}
	
	private Integer totalScore() {
		return this.deathsList.size() - this.killsList.size();
	}
	
	public int compareTo(Player player) {
		return totalScore().compareTo(player.totalScore());
	}
}
