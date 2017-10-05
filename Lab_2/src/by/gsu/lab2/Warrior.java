package by.gsu.lab2;

public class Warrior extends Character{
	private String weaponType;
	private String shieldShape;
	public String getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	public String getShieldShape() {
		return shieldShape;
	}
	public void setShieldShape(String shieldShape) {
		this.shieldShape = shieldShape;
	}
	public Warrior(String name, int health, int strength, int agility) {
		super(name, health, strength, agility);
		// TODO Auto-generated constructor stub
	}


}
