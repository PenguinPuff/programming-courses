package de.tum.cit.ase;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a CargoShip that can carry containers of a specific type.
 * It extends the Container class.
 *
 * @param <T> the type of the content that the containers of this ship can carry
 */
// TODO 2.1: Make this class extend the ContainerShip class, and use generics to specify the type of the content that the containers of this ship can carry
public class CargoShip<T extends Comparable<T>> extends ContainerShip<T> {
    // TODO 2.1: Add a private field to store the containers that are currently on the ship
    private List<Container<T>> containers;
    /**`
     * Constructor for the CargoShip class.
     * CargoShips always have a capacity of 100 containers and are of type CARGO.
     * Initializes the containers list.
     */
    // TODO 2.1: Add a constructor that initializes the containers list
    public CargoShip() {
        super(100); // Initialize the capacity to 100
        this.containers = new ArrayList<>();
    }

    /**
     * This method is used to load a container onto the ship.
     * It checks if the number of containers on the ship is less than the capacity.
     * If the check passes, the container is added to the ship.
     * If the check fails, an IllegalArgumentException is thrown.
     *
     * @param container the container to be loaded onto the ship
     * @throws IllegalArgumentException if the ship is full
     */
    // TODO 2.2: Add a method to load a container onto the ship
    public void load(Container<T> container) {
        if (containers.size() >= this.capacity) {
            throw new IllegalArgumentException("The ship is full!");
        }
        containers.add(container);
    }

    /**
     * This method is used to unload a container from the ship.
     * It checks if the ship is empty.
     * If the ship is not empty, the last container that was loaded onto the ship is removed and returned.
     * If the ship is empty, an IllegalStateException is thrown.
     *
     * @return the container that was unloaded from the ship
     * @throws IllegalStateException if the ship is empty
     */
    // TODO 2.3: Add a method to unload a container from the ship
    public Container<T> unload() {
        if (containers.isEmpty()) {
            throw new IllegalStateException("No containers to unload!");
        }
        return containers.remove(containers.size() - 1);
    }


    /**
     This method will iterate through the containers on the ship
     and find the one with the "heaviest" (or largest) content,
     assuming that T implements Comparable<T>.
     Uncomment it and test on the `Main` class
     */
/*
    public Container<T> findHeaviestContainer() {
        if (containers.isEmpty()) {
            return null; // Or throw an exception if no containers are available
        }
        Container<T> heaviest = containers.get(0);
        for (Container<T> container : containers) {
            if (container.getContent().compareTo(heaviest.getContent()) > 0) {
                heaviest = container;
            }
        }
        return heaviest;
    }
 */
}
