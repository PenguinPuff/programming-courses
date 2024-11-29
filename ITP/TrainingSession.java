package de.tum.cit.ase;

import java.util.ArrayList;
import java.util.List;

public class TrainingSession {
    private String id;
    private String sessionName;
    private Commander commander;
    private List<Cadet> cadets;
    private SpaceHall spaceHall;

    // TODO Part 2: Implement the Lecture class with all attributes and getters
    public TrainingSession(String id, String sessionName, Commander commander, SpaceHall spaceHall) {
        this.id = id;
        this.sessionName = sessionName;
        this.commander = commander;
        this.spaceHall = spaceHall;
        this.cadets = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public Commander getCommander() {
        return commander;
    }

    public void setCommander(Commander commander) {
        this.commander = commander;
    }


    // TODO Part 2.1: implement the addParticipant method
    public void addParticipant(Participant p) {
        if (p instanceof Cadet) {
            if (cadets.contains(p)) {
                System.out.println(p.getLastName() + " spaceID:" + p.getSpaceID() + " already attends/leads the training session.");
            } else {
                cadets.add((Cadet) p);
            }
        } else if (p instanceof Commander) {
            if (this.commander != null) {
                System.out.println("This training session already has a commander!");
            } else {
                this.commander = (Commander) p;
            }
        }
    }

    // TODO Part 2.2: implement the addParticipants method
    public void addParticipants(List<Participant> participants) {
        for (Participant p : participants) {
            addParticipant(p);
        }
    }

    // TODO Part 2.3: implement the takePlace method
    public void takePlace() {
        if (spaceHall != null) {
            spaceHall.placeCadets(cadets);
            if (commander != null) {
                commander.openSession(this);
                commander.closeSession(this);
            }
            spaceHall.empty();
        }
    }
}
