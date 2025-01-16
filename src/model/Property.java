package model;

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
	}

	public void payRent(Player player, Board board) {
		if (owner != player) {
			int rent = price;
			// ***add logic if own the same colors later***
			if(board.ownSameColor(owner, colour)) {
				player.payRent(rent*=2);
			}
			else player.payRent(rent);
			owner.receiveRent(rent);
		}
	}

}
