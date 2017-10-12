package by.gsu.lab2;

public class Monster extends Character {
	private float teethLength;
	private float clawsLength;
	private int pawsQuantity;

	public Monster(String name, int health, int strength, int agility, float teethLength, float clawsLength,
			int pawsQuantity) {
		super(name, health, strength, agility);
		this.teethLength = teethLength;
		this.clawsLength = clawsLength;
		this.pawsQuantity = pawsQuantity;
	}

	public Monster(String name, int health, int strength, int agility) {
		super(name, health, strength, agility);
	}

	public Monster(String name, int health, int strength, int agility, float teethLength, float clawsLength) {
		super(name, health, strength, agility);
		this.teethLength = teethLength;
		this.clawsLength = clawsLength;
	}

	public float getTeethLength() {
		return teethLength;
	}

	public void setTeethLength(int teethLength) {
		this.teethLength = teethLength;
	}

	public float getClawsLength() {
		return clawsLength;
	}

	public void setClawsLength(int clawsLength) {
		this.clawsLength = clawsLength;
	}

	public int getPawsQuantity() {
		return pawsQuantity;
	}

	public void setPawsQuantity(int pawsQuantity) {
		this.pawsQuantity = pawsQuantity;
	}

	@Override
	public float Attack(float ttlDmg) {
		super.Attack(ttlDmg);
		ttlDmg = getStrength() * getAgility() * teethLength * clawsLength * pawsQuantity;
		return ttlDmg;
	}

	@Override
	public String toString() {
		return "Monster [" + super.toString() + "teethLength=" + teethLength + ", clawsLength=" + clawsLength
				+ ", pawsQuantity=" + pawsQuantity;
	}

}
