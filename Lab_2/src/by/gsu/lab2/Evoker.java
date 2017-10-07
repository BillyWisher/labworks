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
	@Override
	public void Attack(float ttlDmg){
		super.Attack(ttlDmg);
		switch (magicType.toLowerCase()){
		case "pyre":
			ttlDmg*=3.1;
			break;
		case "lightning":
			ttlDmg*=3.2;
			break;
		case "elemental":
			ttlDmg*=3.25;
			break;
		default:
			break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
