package gamePlay;

import fileLoader.Loader;
import model.Board;

import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String args[]) {
		
		Board board = new Board("board.json");
		 System.out.println("Board Size: " + board.getBoardSize());
		 System.out.println("Board Tile; " + board.getTile(2).getName());

	}
	
	
}
