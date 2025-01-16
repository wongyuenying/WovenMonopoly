package model;

public class Player {

	private String name;
	private int money;
	private int position;
	private boolean isBankrupt;

	public Player(String name, int money) {
		this.name = name;
		this.money = money;
		this.position = 0;
		this.isBankrupt = false;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoney(int money) {
		this.money = money;
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

