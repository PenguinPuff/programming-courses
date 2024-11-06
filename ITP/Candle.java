package de.tum.cit.ase;

public class Candle {
    // attributes
    private double radius;
    private double height;
    private boolean burning;

    // static attributes
    private static final double maxHeight = 10.0;
    private static final double maxRadius = 2.0;

    // constructors
    public Candle(double radius, double height) {
        this.radius = radius;
        this.height = height;
        this.burning = false;
    }

    // getters and setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(boolean burning) {
        this.burning = burning;
    }

    // methods
    public void light() {
        this.burning = true;
    }

    public double calculateWeight() {
        return 3.14 * radius * radius * height * 0.95;
    }

    public static double calculateMaxWeight() {
        return 3.14 * maxRadius * maxRadius * maxHeight * 0.95;
    }
}

