package de.tum.cit.ase.exception;

public class MissingCPUException extends BootFailedException {
    public MissingCPUException() {
        super("Could not identify the CPU.");
    }
}
