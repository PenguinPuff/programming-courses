package de.tum.cit.ase;

public class Broom {
    private double avgVelocity;
    private double currentVelocity;
    private Witch witch;

    // Constructors
    public Broom(Witch witch, double avgVelocity, double currentVelocity) {
        this.witch = witch;
        this.avgVelocity = avgVelocity;
        this.currentVelocity = currentVelocity;
    }

    // Getter and Setter
    public Witch getWitch() {
        return witch;
    }

    public void setWitch(Witch witch) {
        this.witch = witch;
    }

    public double getAvgVelocity() {
        return avgVelocity;
    }

    public void setAvgVelocity(double avgVelocity) {
        this.avgVelocity = avgVelocity;
    }

    public double getCurrentVelocity() {
        return currentVelocity;
    }

    public void setCurrentVelocity(double currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    // Method to calculate max velocity based on the witch's experience
    public double calculateMaxVelocity() {
        if (witch.isExperiencedBroomOperator()) {
            return avgVelocity * 1.5;
        } else {
            return avgVelocity;
        }
    }

    // Method to calculate the difference between current and average velocity
    public double distanceBetweenCurrentAndAverage() {
        return currentVelocity - avgVelocity;
    }

    // toString()
    @Override
    public String toString() {
        return "Broom{" +
                "witch=" + witch +
                "avgVelocity=" + avgVelocity +
                ", currentVelocity=" + currentVelocity +
                '}';
    }
}
