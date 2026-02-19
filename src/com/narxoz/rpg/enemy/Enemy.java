package com.narxoz.rpg.enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
class Enemy implements Cloneable  {
    protected String name;
    protected int health;
    protected Ability ability;
    protected LootTable loot;

    public void setHealth(int health) { this.health = health; }
    public void setAbility(Ability ability) { this.ability = ability; }
    public void setLoot(LootTable loot) { this.loot = loot; }

    @Override
    public Enemy clone() {
        try {
            return (Enemy) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void showStatus() {
        System.out.println("Враг: " + name + " [HP: " + health + "]");
        ability.cast();
        loot.display();
    }

}
