package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class Warrior {

    protected String name;
    protected int health;
    protected int strength;
    protected List<Ability> abilities;

    public Warrior(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.abilities = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0)
            health = 0;
    }

    // TODO: 2.1 Implement the method getAvailableAbilities
    public List<Ability> getAvailableAbilities(){
        List<Ability> availableAbilities = new ArrayList<>();
        for (Ability ability : abilities){
            if (ability.isReady()){
                availableAbilities.add(ability);
            }
        }
        return availableAbilities;
    }

    // TODO: 2.2 Implement the method updateAbilityCooldowns
    public void updateAbilityCooldowns(){
        for (Ability ability : abilities){
            ability.updateCooldown();
        }
    }

    // TODO: 2.3 Implement the method calculateDamage
    public int calculateDamage(Ability ability){
        return ability.getBaseDamage() + strength;
    }
}
