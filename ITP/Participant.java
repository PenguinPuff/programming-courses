package de.tum.cit.ase;

// TODO Part 1.1 Make the Participant class abstract and implement all attributes and getter and setter methods
public abstract class Participant {
    private String firstName;
    private String lastName;
    private String spaceID;

    // TODO Part 1.1.1 create the abstract method attend(TrainingSession trainingSession)
    public Participant(String firstName, String lastName, String spaceID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.spaceID = spaceID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpaceID() {
        return spaceID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpaceID(String spaceID) {
        this.spaceID = spaceID;
    }

    public abstract void attend(TrainingSession trainingSession);
}
