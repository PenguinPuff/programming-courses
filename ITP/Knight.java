package de.tum.in.ase;

public class Knight extends Warrior{
    // TODO: 4. Implement the class Knight
    private int stamina;
    private static final int MAX_STAMINA = 100;

    public Knight(String name, Ability ability1, Ability ability2, Ability ability3) {
        super(name, 150, 12); // Base health: 150, Strength: 12
        this.stamina = MAX_STAMINA;
        addAbility(ability1);
        addAbility(ability2);
        addAbility(ability3);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = Math.min(stamina, MAX_STAMINA); // Stamina cannot exceed MAX_STAMINA
    }

    // TODO: 4.1 Implement the method calculateDamage
    @Override
    public int calculateDamage(Ability ability) {
        if (stamina >= 20) {
            stamina -= 20;
            return (int) ((ability.getBaseDamage() + strength) * 1.05);
        } else {
            return (int) ((ability.getBaseDamage() + strength) * 0.5);
        }
    }
    
    // TODO: 4.2 Implement the method updateAbilityCooldowns
    @Override
    public void updateAbilityCooldowns() {
        super.updateAbilityCooldowns();
        stamina = Math.min(stamina + 15, MAX_STAMINA);
    }

}