package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FireAbility;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.FireLoot;
import java.util.Arrays;
import java.util.List;

public class FireEnemyFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        return Arrays.asList(new FireAbility("Flame Breath"), new FireAbility("Meteor"));
    }
    @Override
    public LootTable createLootTable() {
        return new FireLoot();
    }

    @Override
    public String createAIBehavior() {
        return "AGGRESSIVE";
    }
}