

public class Gorrilla extends Mammal {
    
    public void throwSomething(){
        System.out.println("The Gorrilla tried throwing a banana peel at your cart!");
        this.setEnergyLevel(this.getEnergyLevel() -5);
    }

    public void eatBananas(){
        System.out.println("That Gorilla ate the banana!");
        this.setEnergyLevel(this.getEnergyLevel() +10);
    }

    public void climb(){
        System.out.println("He is climbing the building to throw more bananas at you!");
        this.setEnergyLevel(this.getEnergyLevel() -10);
    }

} //Ends Gorilla/Mammal
