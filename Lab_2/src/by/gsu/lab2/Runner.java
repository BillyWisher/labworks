package by.gsu.lab2;
import by.gsu.lab2.Character;
import by.gsu.lab2.Evoker;
import by.gsu.lab2.Monster;
import by.gsu.lab2.Warrior;
public class Runner {

	public static void main(String[] args) {
		Character[] characterList = {
			new Character("Burd", 900, 15, 15),
			new Character("Spider", 450, 7, 21),
			new Character("Wolf", 700, 16, 22),
			new Character("Stranger", 1100, 24, 17),
			new Character("Wanderer", 1050, 20, 19),
			new Warrior("The Greatest One", 2400, 40, 20, "doublehanded", "stout"),
			new Warrior("Earth Shaker", 2100, 35, 23, "enchanted", "no shield"),
			new Evoker("Jakiro", 1750, 31, 19, "pyre"),
			new Evoker("Zeus", 1700, 30, 20, "lightning"),
			new Monster("Ogre", 2900, 45, 15, 0.35f, 0.79f, 4),
			new Monster("Undying", 2800, 42, 19, 0.7f, 0.85f, 6)
		};
		float totalDamage = 0;
		for(int i=1; i<characterList.length; i++){
			System.out.println(characterList[i] + ", damage=" + Float.toString(characterList[i].Attack(totalDamage)) + "]");
		}
	}

}
