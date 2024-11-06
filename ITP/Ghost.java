package de.tum.cit.ase;

public class Ghost {
    // attributes
    private String temper;
    private int age;
    private double weight;

    private static final double maxWeight = 20.0; // static

    // constructor
    public Ghost(String temper, int age, double weight) {
        this.temper = temper;
        this.age = age;
        this.weight = weight;
    }

    // getters and setters
    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // methods
    public double calculateWeight(){
        return weight;
    }

    public double scarePower() {
        return age * weight;
    }

    public static double calculateMaxWeight() {
        return maxWeight;
    }
}

