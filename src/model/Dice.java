package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import fileLoader.Loader;

public class Dice {

	private Queue<Integer> rolls;

	//Queue<Integer> rollData

	public Dice(String filepath) {
		List<Integer> rollData = Loader.loadRolls(filepath);
		this.rolls = new LinkedList<>(rollData);
	}

	// Return the rolls number and pop it out of the queue.
	public int roll() {
		return rolls.poll();
	}

	public boolean endOfRolls() {
		return rolls.isEmpty();
	}
}
