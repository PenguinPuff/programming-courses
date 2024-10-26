package de.tum.cit.ase;

public class Witch {
    private String name;
    private int age;
    private boolean experiencedBroomOperator;

    // Constructors
    public Witch(String name, int age, boolean experiencedBroomOperator) {
        this.name = name;
        this.age = age;
        this.experiencedBroomOperator = experiencedBroomOperator;
    }

    public static final int PILOTS_RETIREMENT_AGE = 65;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isExperiencedBroomOperator() {
        return experiencedBroomOperator;
    }

    public void setExperiencedBroomOperator(boolean experiencedBroomOperator) {
        this.experiencedBroomOperator = experiencedBroomOperator;
    }

    // Static method to check retirement
    public static boolean isRetired(int age) {
        return age >= PILOTS_RETIREMENT_AGE;
    }

    // Method to welcome passengers
    public String welcomePassengers() {
        return "Welcome on board! My name is " + name;
    }

    // Auto-generated toString() (by IntelliJ or manually)
    @Override
    public String toString() {
        return "Witch{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", experiencedBroomOperator=" + experiencedBroomOperator +
                '}';
    }
}