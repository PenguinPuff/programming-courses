package de.tum.cit.ase;

public class Tire {
    private float pressure;

    public Tire(String pressure) {
        this.pressure = Float.parseFloat(pressure);
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "pressure=" + pressure +
                '}';
    }
}
