package de.tum.cit.ase.exception;

public class MissingGPUException extends BootFailedException {
    public MissingGPUException() {
        super("Could not identify the GPU.");
    }
}
