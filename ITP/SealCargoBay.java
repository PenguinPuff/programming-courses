package de.tum.cit.ase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SealCargoBay {
	// TODO 2.1: Add attributes
    private final String cargoBayId;
    private final Map<String, Set<CargoCrate>> crateSortingArea;

	// TODO 2.1: Add constructor
    public SealCargoBay(String cargoBayId){
        this.cargoBayId = cargoBayId;
        this.crateSortingArea = new HashMap<>();
    }

	// TODO 2.1: Add getCargoBayId() method
    public String getCargoBayId(){return cargoBayId;}


	// TODO 2.2: Add acceptIncomingCrate(CargoCrate cargoCrate) method
    public void acceptIncomingCrate (CargoCrate cargoCrate){
        crateSortingArea.putIfAbsent(cargoCrate.getSealshipId(), new HashSet<>());
        crateSortingArea.get(cargoCrate.getSealshipId()).add(cargoCrate);
    }

	// TODO 2.3: Add releaseCratesForSealship(String sealshipId) method
    public Set<CargoCrate> releaseCratesForSealship(String sealshipId) {
        return crateSortingArea.containsKey(sealshipId) ? crateSortingArea.remove(sealshipId) : new HashSet<>();
    }
}
