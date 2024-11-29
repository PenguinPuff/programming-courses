package de.tum.cit.ase;

import java.util.ArrayList;
import java.util.List;

public class Commander extends Participant {
    private String rank;
    private List<TrainingSession> trainingSessions;

    public Commander(String firstName, String lastName, String spaceID, String rank) {
        super(firstName, lastName, spaceID);
        this.rank = rank;
        this.trainingSessions = new ArrayList<>();
    }

    // TODO Part 1.3: Implement the Commander class with all attributes and getters and setters
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }

    // TODO Part 1.3.1: Implement the attend method
    @Override
    public void attend(TrainingSession trainingSession) {
        if (trainingSession.getCommander() != null) {
            // If the current commander is already leading the session
            if (trainingSession.getCommander().equals(this)) {
                System.out.println(getLastName() + " spaceID:" + getSpaceID() + " already attends/leads the training session.");
            } else {
                // Another commander is already assigned
                System.out.println("This training session already has a commander!");
            }
        } else {
            // Assign this commander to the session if none is assigned
            trainingSession.setCommander(this);
        }
    }


    // TODO Part 1.3.2: Implement the openSession method
    public void openSession(TrainingSession trainingSession) {
        System.out.println("Welcome to Training Session " + trainingSession.getSessionName() + "! I'm " + rank + " " + " " + getLastName() + ".");
    }


    // TODO Part 1.3.3: Implement the closeSession method
    public void closeSession(TrainingSession trainingSession) {
        System.out.println("Training complete. Remember, in space, precision is survival.");
    }

    // TODO Part 1.3.4: Implement the addSession method
    public void addSession(TrainingSession trainingSession) {
        if (trainingSession.getCommander() == null) {
            trainingSession.setCommander(this);
            trainingSessions.add(trainingSession);
        } else if (!trainingSession.getCommander().getSpaceID().equals(this.getSpaceID())) {
            System.out.println("Training session " + trainingSession.getSessionName() + " is already assigned to another commander.");
        }
    }

    // TODO Part 1.3.5: Implement the toString method
    @Override
    public String toString() {
        return rank + " " + getLastName();
    }

}
