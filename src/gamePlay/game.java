package gamePlay;

import java.util.List;

import model.Board;
import model.Dice;
import model.Go;
import model.Player;
import model.Property;

public class Game {
	private List<Player> players;
	private Board board;
	private Dice dice;
	private String gameName;

	public Game(List<Player> players, Board board, Dice dice, String gameName) {
		this.players = players;
		this.board = board;
		this.dice = dice;
		this.gameName = gameName;
	}

	public void start() {
		while (!isGameOver()) {

			for (Player player : players) {
				playTurn(player);

				// Check is the player bankrupt after each turn, end if it is.
				if (isGameOver()) {
					break;
				}
			}

		}
		declareResult();

	}

	private void playTurn(Player player) {

		int initialPosition = player.getPosition();
		int roll = dice.roll();
		player.move(roll, board.getBoardSize());

		// Check if the player pass Go
		if (player.getPosition() < initialPosition) {
			player.receiveRent(1);
			System.out.println("Player "+ player.getName() + "just passed Go.");
		}

		Object currentTile = board.getTile(player.getPosition());

		if (currentTile instanceof Property) {

			Property property = (Property) currentTile;

			// Buy the property is it is not owned and there is enough money for the player
			// to buy it.
			if (!property.isOwned() && player.getMoney() >= property.getPrice()) {
				property.buyProperty(player);
			}

			// Pay rental if the property is not owned by the player
			else if (property.isOwned() && property.getOwner() != player) {
				property.payRent(player, board);
			}

		}
	}

	public boolean isGameOver() {

		// Loop through all the players to see if any players are bankrupt.
		for (Player player : players) {
			if (player.isBankrupt()) {
				return true;
			}
		}

		// Check if there is any rolls left.
		if (dice.endOfRolls())
			return true;

		return false;
	}

	private void declareResult() {
		int max = 0;
		Player winner = null;
		for(Player player: players) {
			if(!player.isBankrupt() && player.getMoney() > max) {
				max = player.getMoney();
				winner = player;
			}
			else if(player.getMoney()== max) {
				winner = null;
			}
		}
		if (winner != null) {
            System.out.println("\nWinner of " + gameName + ":" + winner.getName());
        } else {
            System.out.println("There is no winner for this game.");
        }

		System.out.println("\nFinal Results:");

		for(Player player: players) {

			Object currentTile = board.getTile(player.getPosition());
	        String positionName=null;

	        if (currentTile instanceof Property) {
	            positionName = ((Property) currentTile).getName();

	        } else if (currentTile instanceof Go) {
	            positionName = "GO";
	        }
			System.out.println(player.getName()+": "+ player.getMoney() + ", Finishes on: " + positionName);
		}

	}

}
