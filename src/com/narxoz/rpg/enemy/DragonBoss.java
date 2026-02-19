package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DragonBoss extends Enemy {

    private String element;
    private Map<Integer, Integer> phases;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public DragonBoss() {
        this.phases = new HashMap<>();
        this.abilities = new ArrayList<>();
    }

    public void setElement(String element) { this.element = element; }
    public void setPhases(Map<Integer, Integer> phases) { this.phases = new HashMap<>(phases); }
    public void setCanFly(boolean canFly) { this.canFly = canFly; }
    public void setHasBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; }
    public void setWingspan(int wingspan) { this.wingspan = wingspan; }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("HP: " + health + " | DMG: " + damage + " | DEF: " + defense + " | SPD: " + speed);
        System.out.println("Element: " + element + " | AI: " + aiBehavior);

        if (lootTable != null) {
            LootTable.generateLoot();
        }
    }

    @Override
    public DragonBoss clone() {
        DragonBoss copy = (DragonBoss) super.clone();
        copy.phases = new HashMap<>(this.phases);
        return copy;
    }

    public void multiplyStats(double multiplier) {
        this.health *= multiplier;
        this.damage *= multiplier;
    }
}