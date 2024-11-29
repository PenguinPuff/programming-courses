package de.tum.cit.ase;

import java.util.List;

public class SpaceHall {
    private String name;
    private int capacity;
    private int rows;
    private Cadet[][] rowsOfCadets;

    // TODO Part 3: Implement the SpaceHall class with all attributes and getters
    public SpaceHall(String name, int capacity) {
        this.name = name;
        if (capacity <= 90) {
            this.capacity = 90;
            this.rows = 3; // 90 seats, 30 per row
        } else {
            this.capacity = capacity - (capacity % 30); // Round down to nearest multiple of 30
            this.rows = this.capacity / 30; // Calculate rows
        }

        // Initialize rowsOfCadets
        rowsOfCadets = new Cadet[rows][30];
    }


    // TODO Part 3.1: Implement the placeCadets method
    public void placeCadets(List<Cadet> waitingCadets) {
        System.out.println("Waiting cadets: " + waitingCadets.size());
        if (waitingCadets.size() > capacity) {
            System.out.println(name + " doesn't have enough places for all the cadets!\nWe can place only the first " + capacity + " out of " + waitingCadets.size() + " cadets.");
        }
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 30; j++) {
                if (index < waitingCadets.size()) {
                    rowsOfCadets[i][j] = waitingCadets.get(index++);
                } else {
                    System.out.println("All cadets are positioned in the training hall.");
                    return;
                }
            }
        }
        System.out.println(this);
    }


    // TODO Part 3.2: Implement the empty method
    public void empty() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 30; j++) {
                rowsOfCadets[i][j] = null;
            }
        }
    }

    // TODO Part 3.3: Implement the toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + ":\n");
        for (int i = 0; i < rows; i++) {
            sb.append("Row ").append(i + 1).append(": ");
            for (int j = 0; j < 30; j++) {
                if (rowsOfCadets[i][j] == null) {
                    sb.append("[]");
                } else {
                    sb.append("[").append(rowsOfCadets[i][j].getFirstName()).append(" ").append(rowsOfCadets[i][j].getLastName()).append("]");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
