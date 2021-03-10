package objectmasters;

public class HumanTest {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human Human1 = new Human("Colby");
		Ninja Ninja1 = new Ninja("Bob the Builder");
		Wizard wizard1 = new Wizard("The Dark Magician");

		Human1.getHealth();
		Human1.getIntelligence();
		Human1.getStealth();
		Human1.getStrength();
		Human1.attack(Human1);
		Ninja1.steal(Human1);
		wizard1.fireball(Ninja1);
		System.out.println(Human1.getHealth());
	}

}
