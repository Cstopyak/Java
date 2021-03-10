

public class bat extends Mammal {
    
    public bat() {
        this.setEnergyLevel(300);
    
    }

    public void fly() {
        System.out.println("The bat looks sick like flying towards me..");
        this.setEnergyLevel(this.getEnergyLevel() - 100);
    }

    public void eatHumans(){
        System.out.println("That bat has taken a bite of me and now im feeling ill");
        this.setEnergyLevel(this.getEnergyLevel() + 25);
    }

    public void attackTown(){
        System.out.println("The Town is being overran by a bats! grab your picks and torches!");
        this.setEnergyLevel(this.getEnergyLevel() - 50);
    }


} //Bat ends
