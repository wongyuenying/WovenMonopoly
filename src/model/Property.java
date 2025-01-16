package model;

// This class represents a property object, subclass of a Tile
public class Property extends Tile {
	private int price;
	private String colour;
	private Player owner;

	public Property(String name, int price, String colour) {
		super(name);
		this.price = price;
		this.colour = colour;
		this.owner = null;
	}

	public int getPrice() {
		return price;
	}

	public String getColour() {
		return colour;
	}

	public Player getOwner() {
		return owner;
	}

	public boolean isOwned() {
		return owner != null;
	}

	public void buyProperty(Player player) {
		owner = player;
		player.payRent(price);
	}

	public void rentalTransaction(Player player, Board board) {
		if (owner != player) {

			int rent = price;

			// Pay double remt if the owner own all properties of the same colour.
			if (board.ownSameColor(owner, colour)) {
				player.payRent(rent *= 2);
				System.out.println(player.getName() + " pays " + owner.getName() + "doubled for " + rent);
			} else {
				player.payRent(rent);
			}

			// Owner of the property receives the rental
			owner.receiveRent(rent);
		}
	}

}
