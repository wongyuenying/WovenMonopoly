package gamePlay;

import fileLoader.Loader;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String args[]) {
		
		List<Map<String, Object>> board = Loader.loadBoard("board.json");
		List<Integer> rolls = Loader.loadRolls("rolls_1.json");
		 System.out.println("Board: " + board);
		 System.out.println("Roll: " + rolls);
	}
	
	
}
