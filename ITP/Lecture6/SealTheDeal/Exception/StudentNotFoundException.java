package de.tum.cit.ase;

public class StudentNotFoundException extends Exception {
    // Default constructor
    public StudentNotFoundException() {
        super();
    }

    // Constructor with a custom message
    public StudentNotFoundException(String message) {
        super(message);
    }
}
