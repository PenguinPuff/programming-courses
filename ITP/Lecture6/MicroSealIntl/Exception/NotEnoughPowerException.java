package de.tum.cit.ase.exception;

public class NotEnoughPowerException extends BootFailedException {
    public NotEnoughPowerException() {
        super("Insufficient power to start the system");
    }
}
