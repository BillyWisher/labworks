package by.gsu.lab2;

public class Monster extends Character {
	private int teethLength;
	private int clawsLength;
	private int pawsQuantity;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public int getTeethLength() {
		return teethLength;
	}

	public void setTeethLength(int teethLength) {
		this.teethLength = teethLength;
	}

	public int getClawsLength() {
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

	public Monster(String name, int health, int strength, int agility, int teethLength, int clawsLength,
			int pawsQuantity) {
		super(name, health, strength, agility);
		this.teethLength = teethLength;
		this.clawsLength = clawsLength;
		this.pawsQuantity = pawsQuantity;
	}
	@Override
	public void Attack(float ttlDmg){
		super.Attack(ttlDmg);
		ttlDmg=ttlDmg*teethLength*clawsLength*pawsQuantity;
	}

}
