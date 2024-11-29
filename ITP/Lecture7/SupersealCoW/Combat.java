package de.tum.in.ase;

import java.util.Random;
import java.util.List;

public class Combat {
    // TODO: 5. Implement the class Combat

    private Random random;

    public Combat(int seed){
        this.random = new Random(seed);
    }

    // TODO: 5.1 Implement the method calculateAbilityAdvantage
    public static int calculateAbilityAdvantage(Ability att, Ability def) {
        if (att.getType() == def.getType()) return 0; // Same type
        if ((att.getType() == AbilityType.SLASH && def.getType() == AbilityType.BLOCK) ||
                (att.getType() == AbilityType.BLOCK && def.getType() == AbilityType.THRUST) ||
                (att.getType() == AbilityType.THRUST && def.getType() == AbilityType.SLASH)) {
            return 1; // Attacker wins
        }
        return -1; // Defender wins
    }


    // TODO: 5.2 Implement the method battle
    public void battle(Warrior warrior1, Warrior warrior2) {
        System.out.println("Battle begins between " + warrior1.getName() + " and " + warrior2.getName() + "!");
        int round = 1;

        while (warrior1.isAlive() && warrior2.isAlive()) {
            System.out.println("\nRound [" + round + "]");
            warrior1.updateAbilityCooldowns();
            warrior2.updateAbilityCooldowns();

            Ability ability1 = randomAbility(warrior1);
            Ability ability2 = randomAbility(warrior2);

            if (ability1 == null || ability2 == null) continue;

            System.out.println(warrior1.getName() + " uses " + ability1.getName() + " dealing " + calculateDamage(ability1, ability2, warrior1, warrior2) + " damage!");
            System.out.println(warrior2.getName() + " uses " + ability2.getName() + " dealing " + calculateDamage(ability2, ability1, warrior2, warrior1) + " damage!");
            System.out.println(warrior1.getName() + ": " + warrior1.getHealth() + " HP");
            System.out.println(warrior2.getName() + ": " + warrior2.getHealth() + " HP");

            round++;
        }

        String winner = warrior1.isAlive() ? warrior1.getName() : warrior2.getName();
        System.out.println("\nBattle is over! " + winner + " wins!");
    }

    private Ability randomAbility(Warrior warrior) {
        List<Ability> available = warrior.getAvailableAbilities();
        if (available.isEmpty()) return null;
        return available.get(random.nextInt(available.size()));
    }

    private int calculateDamage(Ability att, Ability def, Warrior attacker, Warrior defender) {
        int advantage = calculateAbilityAdvantage(att, def);
        double damageMultiplier = advantage == 1 ? 1.5 : (advantage == -1 ? 0.5 : 1.0);
        int damage = (int) (attacker.calculateDamage(att) * damageMultiplier);
        defender.takeDamage(damage);
        att.triggerCooldown();
        return damage;
    }
}
