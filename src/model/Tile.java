package model;

// This class represents a tile on the boardgame
public abstract class Tile {
	private String name;

	public Tile(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}
}
