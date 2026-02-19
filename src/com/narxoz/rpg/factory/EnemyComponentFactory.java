package com.narxoz.rpg.factory;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

public interface EnemyComponentFactory {
    Ability createAbility();
    LootTable createLoot();
}
