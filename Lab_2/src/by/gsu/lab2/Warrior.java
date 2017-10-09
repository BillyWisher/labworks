package by.gsu.lab2;

public class Warrior extends Character{
	private String weaponType;
	private String shieldShape;
	
	public Warrior(String name, int health, int strength, int agility, String weaponType, String shieldShape) {
		super(name, health, strength, agility);
		this.weaponType = weaponType;
		this.shieldShape = shieldShape;
	}

	public Warrior(String name, int health, int strength) {
		super(name, health, strength);
		// TODO Auto-generated constructor stub
	}

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
	
	@Override
	public String toString() {
		return "Warrior [name=" + getName() + ", health=" + getHealth() + ", strength=" + getStrength() + ", agility()=" + getAgility()
				+ ", weapon type=" + weaponType+ ", shield shape=" + shieldShape;
	}

	@Override
	public float Attack(float ttlDmg) {
		super.Attack(ttlDmg);
		switch (weaponType.toLowerCase()){
		case "singlehanded":
			ttlDmg=getStrength()*getAgility()*1.95f;
			break;
		case "doublehanded":
			ttlDmg=getStrength()*getAgility()*2.47f;
			break;
		case "enchanted":
			ttlDmg=getStrength()*getAgility()*3.6f;
			break;
			default:
				break;
		}
		return ttlDmg;
	}
}
