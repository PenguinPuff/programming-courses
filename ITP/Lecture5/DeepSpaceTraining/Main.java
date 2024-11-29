package de.tum.cit.ase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Test your implementation here

        // Create a Commander
        Commander krusche = new Commander("Stephan", "Krusche", "C001", "General");

        // Create SpaceHalls
        SpaceHall interimsII = new SpaceHall("Interims II", 380);
        SpaceHall friedrichLBauer = new SpaceHall("Friedrich L. Bauer", 522);
        SpaceHall audimaxGalileo = new SpaceHall("Audimax im Galileo", 1236);

        // Create TrainingSessions
        TrainingSession itp = new TrainingSession("CIT5230000", "Introduction to Programming", krusche, interimsII);
        TrainingSession pse = new TrainingSession("IN2081", "Patterns in Software Engineering", krusche, friedrichLBauer);
        TrainingSession eist = new TrainingSession("IN0006", "Einführung in die Softwaretechnik", krusche, audimaxGalileo);

        // Add TrainingSessions to the Commander
        krusche.addSession(itp);
        krusche.addSession(pse);
        krusche.addSession(eist);

        // Generate cadets and add them to the ITP session
        List<Participant> participantsITP = new LinkedList<>();
        participantsITP.add(krusche); // Add the Commander to the session
        participantsITP.addAll(generateCadets(737)); // Add 737 cadets
        itp.addParticipants(participantsITP);

        // Start the training session
        itp.takePlace();
    }

    public static List<Cadet> generateCadets(int amount) {
        List<Cadet> cadets = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            String spaceID = "S" + String.format("%04d", i); // Generate a unique spaceID, e.g., S0001, S0002
            cadets.add(new Cadet("FirstName" + i, "LastName" + i, spaceID));
        }
        return cadets;
    }
    // TODO Part 4.1: Implement the generateCadets method
}
