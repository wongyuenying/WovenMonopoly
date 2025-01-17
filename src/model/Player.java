package model;

// Represents a player in the game
public class Player {
	private String name;
	private int money;
	private int position;
	private boolean isBankrupt;
	private final int startingMoney;

	public Player(String name, int money) {
		this.name = name;
		this.money = money;
		this.startingMoney = money;
		this.position = 0;
		this.isBankrupt = false;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public int getPosition() {
		return position;
	}

	public boolean isBankrupt() {
		return isBankrupt;
	}

	public void reset() {
		this.money = startingMoney;
        this.position = 0;
        this.isBankrupt = false;
	}

	public void move(int steps, int boardSize) {
		position = (position + steps) % boardSize;
	}

	public void payRent(int amount) {
		money -= amount;
		checkIsBankrupt();
	}

	private void checkIsBankrupt() {
		if (money < 0) {
			isBankrupt = true;
		}
	}

	public void receiveRent(int amount) {
		money += amount;
	}

}

