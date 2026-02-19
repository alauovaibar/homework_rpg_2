package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;

public class Goblin extends Enemy {

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.aiBehavior = "COWARDLY"; // Гоблины трусливы по умолчанию
        this.abilities = new ArrayList<>();
    }
    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Abilities: " + (abilities != null ? abilities.size() : 0));

        if (lootTable != null) {
            LootTable.generateLoot();
        }
        System.out.println("--------------------------");
    }

    @Override
    public Goblin clone() {

        return (Goblin) super.clone();
    }

    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
    }

    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }
}
