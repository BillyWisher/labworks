package by.gsu.lab2;

public class Character {
	private String name;
	private int health;
	private int strength;
	private int agility;

	public Character(String name, int health, int strength, int agility) {
		super();
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.agility = agility;
	}
	@Override
	public String toString() {
		return "Character [name=" + name + ", health=" + health + ", strength=" + strength + ", agility=" + agility
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public static void Attack(String[] args) {
		

	}


}
