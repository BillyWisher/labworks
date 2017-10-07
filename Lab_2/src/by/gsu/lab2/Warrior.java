package by.gsu.lab2;

public class Warrior extends Character{
	private String weaponType;
	private String shieldShape;
	public Warrior(String name, int health, int strength, int agility) {
		super(name, health, strength, agility);
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
	public void Attack(float ttlDmg) {
		super.Attack(ttlDmg);
		switch (weaponType.toLowerCase()){
		case "singlehanded":
			ttlDmg*=1.95;
			break;
		case "doublehanded":
			ttlDmg*=2.47;
			break;
		case "enchanted":
			ttlDmg*=3.6;
			break;
			default:
				break;
		}
	}
}
