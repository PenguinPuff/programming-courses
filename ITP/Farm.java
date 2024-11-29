package de.tum.cit.ase;

import java.util.ArrayList;
import java.util.List;

public class Farm {
	//TODO 3.1: Implement Farm as described in task
	private List<Animal> animals;

	// Constructor initializing the ArrayList
	public Farm() {
		animals = new ArrayList<>();
	}

	// Getter for animals
	public List<Animal> getAnimals() {
		return animals;
	}

	// Setter for animals
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	// Method to add an animal to the farm
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	// Method to feed all animals
	public void feedAllAnimals() {
		for (Animal animal : animals) {
			System.out.println(animal.messageOnFeed());
		}
	}


	/**
	 * Sings farm song for all animals in the farm
	 */
	public void singFarmSong() {
		// TODO 3.2: Let the Animals sing!
		for (Animal animal : animals) {
			singFarmSongVerse(animal);
		}
	}

	/**
	 * Prints the animal specific song given an animal
	 *
	 * @param animal - animal whose song is to be printed
	 */

	private void singFarmSongVerse(Animal animal) {
		String animalType = animal.getClass().getSimpleName();
		String sound = animal.messageOnFeed();
		System.out.println("Old MacDonald had a farm\n" +
				"Ee i ee i o\n" +
				"And on his farm he had some "+  animalType + "s");
		System.out.println("Ee i ee i oh");
		System.out.println("With a ");
		System.out.println(sound);
		System.out.println(sound);
		System.out.println("here, and a ");
		System.out.println(sound);
		System.out.println(sound);
		System.out.println("there.");
		System.out.println("Here a ");
		System.out.println(sound);
		System.out.println("There a ");
		System.out.println(sound);
		System.out.println("Everywhere a ");
		System.out.println(sound);
		System.out.println(sound);
		System.out.println("Old MacDonald had a farm\n" +
				"Ee i ee i o");
	}
}
