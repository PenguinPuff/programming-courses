package de.tum.cit.ase;

public class Pig extends Animal implements Rideable {

    // Constructor
    public Pig(String name) {
        super(name);
    }

    // Implementing messageOnFeed from Animal
    @Override
    public String messageOnFeed() {
        return "Oink!";
    }

    // Implementing messageOnRide from Rideable
    @Override
    public String messageOnRide() {
        return "Riding on Pig " + getName();
    }
}

