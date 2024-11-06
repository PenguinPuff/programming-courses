package de.tum.cit.ase;

public class JackOLantern {
    // composition attributes
    private Pumpkin pumpkin;
    private Candle candle;
    private Ghost ghostOfHalloween;

    // constructor
    public JackOLantern(Pumpkin pumpkin, Candle candle, Ghost ghostOfHalloween) {
        this.pumpkin = pumpkin;
        this.candle = candle;
        this.ghostOfHalloween = ghostOfHalloween;
        this.pumpkin.calculateWeight();
        this.pumpkin.carveFace(ghostOfHalloween.getTemper());
    }

    // methods\
    public double calculateLanternWeight() {
        return pumpkin.getWeight() + candle.calculateWeight() + ghostOfHalloween.calculateWeight();
    }

    public double hauntedLantern() {
        candle.light();
        return ghostOfHalloween.scarePower();
    }

    public static double calculateMaxLanternWeight() {
        return Pumpkin.calculateMaxWeight() + Candle.calculateMaxWeight() + Ghost.calculateMaxWeight();
    }

    // missing getters
    public Pumpkin getPumpkin() {
        return pumpkin;
    }

    public Ghost getGhost() {
        return ghostOfHalloween;
    }

    public Candle getCandle() {
        return candle;
    }

    // missing setters

    public void setCandle(Candle candle) {
        this.candle = candle;
    }

    public void setPumpkin(Pumpkin pumpkin){
        this.pumpkin = pumpkin;
    }

    public void setGhost(Ghost ghostOfHalloween){
        this.ghostOfHalloween = ghostOfHalloween;
    }
}
