package de.tum.in.ase;

public class Ability {
    // TODO: 1. Implement the class Ability
    private String name;
    private AbilityType type;
    private int baseDamage;
    private int cooldown;
    private int currentCooldown;

    public Ability(String name, AbilityType type, int baseDamage, int cooldown){
        this.name = name;
        this.type = type;
        this.baseDamage = baseDamage;
        this.cooldown = cooldown;
        this.currentCooldown = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public AbilityType getType() {
        return type;
    }

    public void setType(AbilityType type) {
        this.type = type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCurrentCooldown() {
        return currentCooldown;
    }

    public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = currentCooldown;
    }

    // TODO: 1.1 Implement the method isReady
    public boolean isReady() {
        return currentCooldown == 0;
    }

    // TODO: 1.2 Implement the method updateCooldown
    public void updateCooldown(){
        if (currentCooldown > 0){
            currentCooldown--;
        }
    }

    // TODO: 1.3 Implement the method triggerCooldown
    public void triggerCooldown(){
        currentCooldown = cooldown;
    }
}
