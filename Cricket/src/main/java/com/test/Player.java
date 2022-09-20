package com.test;

import java.util.Comparator;

class PlayerAverageScoreComparator implements Comparator<Player>{

    @Override
    public int compare(Player player1, Player player2) {
        return (int) (player2.getAverage() - player1.getAverage());
    }
}

public class Player {
	private int id;
	private String name;
	private int matches;
	private int socre;
	private int average;
	public int getAverage() {
		return average;
	}
	public void setAverage(int score,int matches) {
		this.average = score/matches;
	}
	private int ducks;
	private int wickets;
	private String players;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getSocre() {
		return socre;
	}
	public void setSocre(int socre) {
		this.socre = socre;
	}
	public int getDucks() {
		return ducks;
	}
	public void setDucks(int ducks) {
		this.ducks = ducks;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public String getPlayers() {
		return players;
	}
	public void setPlayers(String players) {
		this.players = players;
	}

	

}
