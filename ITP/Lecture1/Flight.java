package de.tum.cit.ase;

public class Flight {
    private Broom broom;
    private String from;
    private String to;
    private double duration;

    // Constructors
    public Flight(String from, String to, double duration, Broom broom) {
        this.broom = broom;
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    // Getter and Setter
    public Broom getBroom() {
        return broom;
    }

    public void setBroom(Broom broom) {
        this.broom = broom;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // Method to estimate flight distance
    public double getEstimatedDistance() {
        return broom.getAvgVelocity() * duration;
    }

    // Method to estimate flight time if max velocity is achieved
    public double getEstimatedTimeWithMaxVelocity() {
        double maxVelocity = broom.calculateMaxVelocity();
        double distance = getEstimatedDistance();
        return distance / maxVelocity;
    }

    // toString()
    @Override
    public String toString() {
        return "Flight{" +
                "broom=" + broom +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", duration=" + duration +
                '}';
    }
}