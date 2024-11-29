package de.tum.in.ase;

public class Berserker extends Warrior {
    private int rage;
    private static final int MAX_RAGE = 100;

    public Berserker(String name, Ability ability1, Ability ability2, Ability ability3) {
        super(name, 120, 15); // Base health: 120, Strength: 15
        this.rage = 0;
        addAbility(ability1);
        addAbility(ability2);
        addAbility(ability3);
    }

    // TODO: 3. Implement the class Berserker
    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = Math.min(rage, MAX_RAGE); // Rage cannot exceed MAX_RAGE
    }

    // TODO: 3.1 Implement the method calculateDamage
    @Override
    public int calculateDamage(Ability ability) {
        double rageMultiplier = 1 + (rage / 100.0);
        int damage = (int) (ability.getBaseDamage() * rageMultiplier) + strength;
        rage = Math.min(rage + 15, MAX_RAGE);
        return damage;
    }

    // TODO: 3.2 Implement the method takeDamage
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        rage = Math.min(rage + 10, MAX_RAGE);
    }
}