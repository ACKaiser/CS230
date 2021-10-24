package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */

public class Team extends Entity {
	
	private List<Player>players = new ArrayList<Player>(); //List of teams
	
	public Team(long id, String name) { //constructor
		super (id, name);
	}
	
	public Player addPlayer(String name) { 
		Player player = null;
		Iterator<Player>playersIterator = players.iterator(); 
		while (playersIterator.hasNext()) { //iterates over list
			Player playerInstance = playersIterator.next(); 
			if (playerInstance.getName().equalsIgnoreCase(name)) { //does name exist?
				player = playerInstance;
			}
			else { //else add to the list
				players.add(player);
			}
		}
		return player;
	}
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}