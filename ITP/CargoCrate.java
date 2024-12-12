package de.tum.cit.ase;

import java.util.Objects;

// TODO 1: Implement the Comparable interface
public class CargoCrate implements Comparable<CargoCrate> {
	private final String sealTag;
	private final String sealshipId;
	private final double weight;

	public CargoCrate(String sealTag, String sealshipId, double weight) {
		this.sealTag = sealTag;
		this.sealshipId = sealshipId;
		this.weight = weight;
	}

	public String getSealTag() {
		return sealTag;
	}

	public String getSealshipId() {
		return sealshipId;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		CargoCrate otherCargoCrate = (CargoCrate) other;
		return Objects.equals(sealTag, otherCargoCrate.sealTag) &&
				Objects.equals(sealshipId, otherCargoCrate.sealshipId) &&
				Objects.equals(weight, otherCargoCrate.weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sealTag, sealshipId, weight);
	}

	// TODO 1: Add compareTo() method
	@Override
	public int compareTo(CargoCrate other){
		return Double.compare(other.weight, this.weight);
	}

	// TODO 1: Add toString() method
	@Override
	public String toString() {
		return String.format("CargoCrate of %s for sealship %s with weight %.1f kg.", sealTag, sealshipId, weight);
	}
}
