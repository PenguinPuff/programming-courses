package de.tum.cit.ase;

public class Cadet extends Participant {

    // TODO Part 1.2: Implement the Cadet class
    public Cadet(String firstName, String lastName, String spaceID) {
        super(firstName, lastName, spaceID);
    }

    // TODO Part 1.2.1: Implement the attend method
    @Override
    public void attend(TrainingSession trainingSession) {
        trainingSession.addParticipant(this);
    }

}
