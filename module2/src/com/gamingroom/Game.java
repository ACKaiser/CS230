package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity { 
	
	private List<Team>teams = new ArrayList<Team>(); //list of active teams
	
	public Game(long id, String name) { //constructor
		super(id, name);
	}
	
	public Team addTeam(String name) { //find existing team or add new team
		Team team = null;
		Iterator<Team>teamsIterator = teams.iterator();
		while (teamsIterator.hasNext()) { //iterates over teams
			Team teamInstance = teamsIterator.next();
			if (teamInstance.getName().equalsIgnoreCase(name)) { //look for team name
				team = teamInstance;
			}
			else {
				teams.add(team); //else add the new team
			}
		}
		return team;
	}
	
	public String toString() {
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
	
}
