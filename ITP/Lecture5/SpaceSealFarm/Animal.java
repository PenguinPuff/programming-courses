package de.tum.cit.ase;

public abstract class Animal {
        private String name;
    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Abstract method to be implemented by subclasses
    public abstract String messageOnFeed();
}
