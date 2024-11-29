package de.tum.cit.ase;

public class Goat extends Animal implements Milkable {

    // Constructor
    public Goat(String name) {
        super(name);
    }

    // Implementing messageOnFeed from Animal
    @Override
    public String messageOnFeed() {
        return "Maah!";
    }

    // Implementing messageOnMilk from Milkable
    @Override
    public String messageOnMilk() {
        return "Goat " + getName() + " is milked";
    }
}
