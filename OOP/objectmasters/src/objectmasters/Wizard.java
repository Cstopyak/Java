package objectmasters;

public class Wizard extends Human {

	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	public Wizard(String name) {
		this.health = 50;
		this.intelligence = 8;
		this.name = name;
	}
	
	
	public void heal(Human human) {
		human.setHealth(human.getHealth() + intelligence);
		
		System.out.println("you have been healed!");
	}
	
	public void fireball(Human human) {
		this.setHealth(human.getHealth()-(intelligence*3));
		System.out.println("A blazing fury has come down on you.");
	}
	
}