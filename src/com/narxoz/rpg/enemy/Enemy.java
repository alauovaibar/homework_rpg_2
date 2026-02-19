package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public abstract class Enemy implements Cloneable {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected String aiBehavior;

    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;

    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setAiBehavior(String aiBehavior) { this.aiBehavior = aiBehavior; }
    public void setAbilities(List<Ability> abilities) { this.abilities = abilities; }
    public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }

    public String getName() { return name; }
    public int getHealth() { return health; }

    @Override
    public Enemy clone() {
        try {
            Enemy copy = (Enemy) super.clone();

            copy.abilities = new ArrayList<>(this.abilities);
            return copy;
        } catch (CloneNotSupportedException e) {

            return null;
        }
    }

    public abstract void displayInfo();
}

