package by.gsu.lab2;

public class Evoker extends Character {
	private String magicType;

	public String getMagicType() {
		return magicType;
	}
	public void setMagicType(String magicType) {
		this.magicType = magicType;
	}
	public Evoker(String name, int health, int strength, int agility, String magicType) {
		super(name, health, strength, agility);
		this.magicType = magicType;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
