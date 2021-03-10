package objectmasters;

public class Ninja extends Human {

	public Ninja() {
		this.stealth = 10;
	}
	public Ninja(String name) {
		this.stealth = 10;
		this.name = name;
	}
	
	
	public void steal(Human human) {
		human.setHealth(human.getHealth()- stealth);
		this.setHealth(this.getHealth() + stealth);
		System.out.println("Stolen!");
	}
	
	public void runAway() {
		this.setHealth(-10);
	}
	
}
