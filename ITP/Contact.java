package de.tum.cit.ase;

public class Contact {
    // TODO 1.1: Add attributes and constructor
    private String name;
    private String phoneNumber;
    private boolean isSealDeputy;

    public Contact(String name, String phoneNumber, boolean isSealDeputy){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isSealDeputy = isSealDeputy;
    }

    // TODO 1.2: Add getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public boolean getIsSealDeputy(){
        return isSealDeputy;
    }

    public void setIsSealDeputy(boolean isSealDeputy){
        this.isSealDeputy = isSealDeputy;
    }

    // TODO 1.3: Add custom toString() method
    @Override
    public String toString() {
        String team = isSealDeputy ? "Seal Sheriff Squad" : "Ghost Riders";
        return name + " can be reached at " + phoneNumber + " and is part of the " + team;
    }
}