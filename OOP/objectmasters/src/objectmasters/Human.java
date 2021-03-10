package objectmasters;

public class Human {
	protected int health = 100;
	protected int strength = 3;
	protected int stealth = 3;
	protected int intelligence = 3;
	protected String name = "";
	
	
	public Human() {
		
	}
	
	public Human(String name){
		this.name = name;
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public void attack(Human human) {
		human.setHealth(human.getHealth() - strength);
	}
	
}
