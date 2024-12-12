package de.tum.cit.ase;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// TODO 3.4: Implement the Iterable interface
public class SealTransporter implements Iterable<CargoCrate> {
    // TODO 3.1: Add attributes
    private final String transporterId;
    private final Queue<CargoCrate> cargo;

    // TODO 3.1: Add constructor
    public SealTransporter(String transporterId) {
        this.transporterId = transporterId;
        this.cargo = new PriorityQueue<>();
    }

    // TODO 3.1: Add getTransporterId() method
    public String getTransporterId() {
        return transporterId;
    }

    // TODO 3.2: Add loadCrate(CargoCrate cargoCrate) method

    public void loadCrate(CargoCrate cargoCrate) {
        cargo.add(cargoCrate);
    }


    // TODO 3.3: Implement collectCratesForSealship(String sealshipId, SealCargoBay sealCargoBay) method
    public void collectCratesForSealship(String sealshipId, SealCargoBay sealCargoBay) {
        System.out.printf("This is seal transporter %s requesting crates for sealship %s from cargo bay %s!%n",
                transporterId, sealshipId, sealCargoBay.getCargoBayId());
        Set<CargoCrate> crates = sealCargoBay.releaseCratesForSealship(sealshipId);
        cargo.addAll(crates);
    }

    // TODO 3.4: Implement iterator() method
    @Override
    public Iterator<CargoCrate> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !cargo.isEmpty();
            }

            @Override
            public CargoCrate next() {
                CargoCrate nextCrate = cargo.remove();
                System.out.printf("Here comes a cargo crate weighing %.2f kg!%n", nextCrate.getWeight());
                return nextCrate;
            }
        };
    }

}
