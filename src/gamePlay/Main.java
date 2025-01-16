package gamePlay;

import java.util.ArrayList;
import java.util.List;
import model.Board;
import model.Dice;
import model.Player;

// Entry point of the program, import and create the board and dice, create players and start the game in this class
public class Main {

	public static void main(String args[]) {

		Board board = new Board("board.json");
		Dice dice1 = new Dice("rolls_1.json");
		Dice dice2 = new Dice("rolls_2.json");

		List<Player> players = new ArrayList<>();
		players.add(new Player("Peter", 16));
		players.add(new Player("Billy", 16));
		players.add(new Player("Charlotte", 16));
		players.add(new Player("Sweedal", 16));

		Game game1 = new Game(players, board, dice1, "game1");
		game1.start();

		// Reset the players data for a new game
		for (Player player : players) {
			player.reset();
		}

		Game game2 = new Game(players, board, dice2, "game2");

		game2.start();

	}

}
