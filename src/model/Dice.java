package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import fileLoader.Loader;

// This class represents a dice in the game
public class Dice {

	private Queue<Integer> rolls;

	public Dice(String filepath) {
		List<Integer> rollData = Loader.loadRolls(filepath);
		this.rolls = new LinkedList<>(rollData);
	}

	// Return the first roll number and pop it out of the queue.
	public int roll() {
		return rolls.poll();
	}

	// Return true if there is no more rolls left
	public boolean endOfRolls() {
		return rolls.isEmpty();
	}
}
