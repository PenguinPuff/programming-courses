package de.tum.cit.ase;

import java.util.Stack;

public class Sealship {
    // TODO 4.1: Add attributes
    private final String sealshipId;
    private final Stack<CargoCrate> cargoHold;
    private boolean departed;
    
    // TODO 4.1: Add constructor
    public Sealship(String sealshipId) {
        this.sealshipId = sealshipId;
        this.cargoHold = new Stack<>();
        this.departed = false;
    }
    
    // TODO 4.1: Add getSealshipId() and isDeparted() methods
    public String getSealshipId() {
        return sealshipId;
    }

    public boolean isDeparted() {
        return departed;
    }


    // TODO 4.2: Implement loadCrate(CargoCrate cargoCrate) method

    public void loadCrate(CargoCrate cargoCrate) {
        cargoHold.push(cargoCrate);
    }
    
    // TODO 4.3: Implement acceptCrates(SealTransporter sealTransporter) method
    public void acceptCrates(SealTransporter sealTransporter) {
        System.out.printf("This is sealship %s accepting crates from seal transporter %s!%n",
                sealshipId, sealTransporter.getTransporterId());
        for (CargoCrate crate : sealTransporter) {
            loadCrate(crate);
        }
    }

    // TODO 4.4: Implement depart() method
    public void depart() {
        departed = true;
        System.out.printf("Sealship %s is departing with %d crates in the cargo hold. Bye bye!%n",
                sealshipId, cargoHold.size());
    }
}
