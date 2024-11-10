package de.tum.cit.ase;

import java.util.ArrayList;
import java.util.List;

public class TrainTrack {
    // Task 2.1: Add attributes to the TrainTrack class
    private int capacity;
    private int amountGhostTrains;
    private List<GhostTrain> stack;

    // Task 2.2: Implement the TrainTrack constructor
    public TrainTrack(int capacity){
        this.capacity = capacity;
        this.amountGhostTrains = 0;
        this.stack = new ArrayList<>();
    }


    // Task 2.4: Implement the amountFreeSpots method
    public int amountFreeSpots() {
        return capacity - amountGhostTrains;
    }

    // Task 2.5: Implement the find method
    public int find(int id) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // Task 2.6: Implement the remove method
    public GhostTrain remove(int id) {
        int index = find(id);
        if (index != -1) {
            GhostTrain removedTrain = stack.remove(index);
            amountGhostTrains--;
            return removedTrain;
        }
        return null;
    }

    // Task 2.7: Implement the push method
    public boolean push(GhostTrain train) {
        if (amountFreeSpots() > 0) {
            stack.add(train);
            amountGhostTrains++;
            return true;
        }
        return false;
    }

    // Task 2.8: Implement the pop method
    public GhostTrain pop() {
        if (amountGhostTrains > 0) {
            GhostTrain departingTrain = stack.remove(stack.size() - 1);
            amountGhostTrains--;
            return departingTrain;
        }
        return null;
    }


    // Task 2.3: Implement the TrainTrack getters and setters
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAmountGhostTrains() {
        return amountGhostTrains;
    }

    public void setAmountGhostTrains(int amountGhostTrains) {
        this.amountGhostTrains = amountGhostTrains;
    }

    public List<GhostTrain> getStack() {
        return stack;
    }

    public void setStack(List<GhostTrain> stack) {
        this.stack = stack;
    }

}
