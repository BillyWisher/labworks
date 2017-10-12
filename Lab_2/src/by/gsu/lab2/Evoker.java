package by.gsu.lab2;

public class Evoker extends Character {
	private String magicType;

	public Evoker(String name, int health, int strength, int agility, String magicType) {
		super(name, health, strength, agility);
		this.magicType = magicType;
	}

	public Evoker(String name, int health, int strength, int agility) {
		super(name, health, strength, agility);
	}

	public Evoker(String name, int health, int agility, String magicType) {
		super(name, health, agility);
		this.magicType = magicType;
	}

	public String getMagicType() {
		return magicType;
	}

	public void setMagicType(String magicType) {
		this.magicType = magicType;
	}

	@Override
	public float Attack(float ttlDmg) {
		super.Attack(ttlDmg);
		switch (magicType.toLowerCase()) {
		case "pyre":
			ttlDmg = getStrength() * getAgility() * 3.1f;
			break;
		case "lightning":
			ttlDmg = getStrength() * getAgility() * 3.2f;
			break;
		case "elemental":
			ttlDmg = getStrength() * getAgility() * 3.25f;
			break;
		default:
			break;
		}
		return ttlDmg;
	}

	@Override
	public String toString() {
		return "Evoker [" + super.toString() + ", magicType=" + magicType;
	}
}
