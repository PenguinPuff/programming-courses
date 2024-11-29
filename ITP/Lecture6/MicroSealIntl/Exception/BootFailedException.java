package de.tum.cit.ase.exception;

public class BootFailedException extends RuntimeException {
    // Superclass for other exceptions.
    public BootFailedException() {
        super("Could not boot the PC, verify the components and try again later.");
    }

    public BootFailedException(String message) {
        super(message);
    }
}
