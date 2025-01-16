package model;

public class Property {

	private String name;
	private int price;
	private String color;
	private Player owner;

	public Property(String name, int price, String color) {
		this.name = name;
		this.price = price;
		this.color = color;
		this.owner = null;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public boolean isOwned() {
		return owner!=null;
	}

	public void buyProperty(Player player) {
		owner = player;
	}

	public void payRent(Player player) {
		if(owner!= player) {

			//***add logic if own the same colors later***

			player.payRent(price);
			owner.receiveRent(price);
		}
	}

}
