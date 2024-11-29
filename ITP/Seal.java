package de.tum.cit.ase;

public class Seal extends Animal implements Rideable, Milkable {

    // Constructor
    public Seal(String name) {
        super(name);
    }

    // Implementing messageOnFeed from Animal
    @Override
    public String messageOnFeed() {
        return "Arf Arf!";
    }

    // Implementing messageOnMilk from Milkable
    @Override
    public String messageOnMilk() {
        return "Seal " + getName() + " is milked";
    }

    // Implementing messageOnRide from Rideable
    @Override
    public String messageOnRide() {
        return "Riding on Seal " + getName();
    }
}


