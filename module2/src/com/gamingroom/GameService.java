package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	private static long nextPlayerId = 1; //next player identifier
	
	private static long nextTeamId = 1; //next team identifier

	private static GameService service = null; 
	
	private GameService() { //Constructor
	}
	
	public static GameService getInstance() { //Check for running game
		if (service == null) {
			service = new GameService(); //if not start new game
			//System.out.println("New Game created.");
		}
		else { //else notify game is already running
			//System.out.println("Game already running.");
		}
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		Iterator<Game> gamesIterator = games.iterator(); //Iterator of type Game
		while (gamesIterator.hasNext()) { //Iterate over game list
			Game gameInstance = gamesIterator.next(); //Set Game to next item
			if (gameInstance.getName().equalsIgnoreCase(name)) { //If name already exists, return gameInstance
				return gameInstance;
			}
		}
		if (game == null) { // if not found, make a new game instance and add to list of games
			game = new Game(nextGameId++, name);
			games.add(game);
		}
		return game; // return the new/existing game instance to the caller
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;		
		Iterator<Game> gamesIterator = games.iterator(); //Iterator
		while (gamesIterator.hasNext()) { //Iterate over games
			Game gameInstance = gamesIterator.next(); //Set Game to next item
			if (gameInstance.getId() == id) { //if game exists, return gameInstance
				return gameInstance;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		Iterator<Game> gamesIterator = games.iterator(); //Iterator
		while (gamesIterator.hasNext()) { //Iterate over list
			Game gameInstance = gamesIterator.next(); //Set Game to next item 
			if (gameInstance.getName().equalsIgnoreCase(name)) { //if game exists, return gameInstance
				game=gameInstance;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	public long getNextPlayerId() {
		return nextPlayerId;
	}
	
	public long getNextTeamId() {
		return nextTeamId;
	}
}
