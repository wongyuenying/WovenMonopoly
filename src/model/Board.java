package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fileLoader.Loader;

public class Board {
	private List<Tile> tiles;

	public Board(String filepath) {
		this.tiles = new ArrayList<>();
		initializeBoard(filepath);
	}

	private void initializeBoard(String filepath) {

		List<Map<String, Object>> fileData = Loader.loadBoard(filepath);

		// Map through the board file data and crete tiles based on the types.

		for (Map<String, Object> tileData : fileData) {
			String type = (String) tileData.get("type");
			Tile tile = initializeTiles(type, tileData);
			tiles.add(tile);
		}
	}

	// Create the tiles based on the type

	private Tile initializeTiles(String type, Map<String, Object> tileData) {

		switch (type) {

		case "go":
			return new Go((String) tileData.get("name"));

		case "property":
			return new Property((String) tileData.get("name"), (int) tileData.get("price"),
					(String) tileData.get("colour"));

		default:
			throw new RuntimeException("Unable to identity the type of tile.");

		}
	}

	public Tile getTile(int position) {
		return tiles.get(position);
	}

	public int getBoardSize() {
		return tiles.size();
	}
	
	public boolean ownSameColor(Player player, String color) {
		for (Tile tile : tiles) {
			if(tile instanceof Property) {
				Property property = (Property) tile;
				if(property.getColour().equals(color) && property.getOwner() != player) {
					return false;
				}
			}
		}
		return true;
	}

}
