package de.tum.cit.ase;

import java.util.ArrayList;
import java.util.List;

public class StorageStation {
    // Task 3.1: Add attributes to the StorageStation class
    private List<TrainTrack> tracks;
    private int amountTracks;

    // Task 3.2: Implement the StorageStation constructor
    public StorageStation(int amountTracks, int trackCapacity) {
        this.amountTracks = amountTracks;
        this.tracks = new ArrayList<>();
        for (int i = 0; i < amountTracks; i++) {
            this.tracks.add(new TrainTrack(trackCapacity));
        }
    }

    // Task 3.4: Implement the addTrack method
    public void addTrack(TrainTrack newTrack) {
        tracks.add(newTrack);
        amountTracks++;
    }

    // Task 3.5: Implement the find method
    public int find(int id) {
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).find(id) != -1) {
                return i;
            }
        }
        return -1;
    }

    // Task 3.6: Implement the arriveStation method
    public TrainTrack arriveStation(GhostTrain train) {
        TrainTrack bestTrack = null;
        int maxFreeSpots = -1;
        for (TrainTrack track : tracks) {
            int freeSpots = track.amountFreeSpots();
            if (freeSpots > maxFreeSpots) {
                maxFreeSpots = freeSpots;
                bestTrack = track;
            }
        }
        if (bestTrack != null && bestTrack.push(train)) {
            return bestTrack;
        }
        return null;
    }

    // Task 3.7: Implement the departStation method
    public GhostTrain departStation() {
        TrainTrack bestTrack = null;
        int minFreeSpots = Integer.MAX_VALUE;
        for (TrainTrack track : tracks) {
            int freeSpots = track.amountFreeSpots();
            if (track.getAmountGhostTrains() > 0 && freeSpots < minFreeSpots) {
                minFreeSpots = freeSpots;
                bestTrack = track;
            }
        }
        if (bestTrack != null) {
            return bestTrack.pop();
        }
        return null;
    }

    // Task 3.3: Implement the StorageStation getters and setters
    public List<TrainTrack> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrainTrack> tracks) {
        this.tracks = tracks;
    }

    public int getAmountTracks() {
        return amountTracks;
    }

    public void setAmountTracks(int amountTracks) {
        this.amountTracks = amountTracks;
    }
}
