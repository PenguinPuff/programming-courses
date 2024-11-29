package de.tum.cit.ase.exception;

public class MissingRAMException extends BootFailedException {
    public MissingRAMException() {
        super("Could not identify the RAM.");
    }
}
