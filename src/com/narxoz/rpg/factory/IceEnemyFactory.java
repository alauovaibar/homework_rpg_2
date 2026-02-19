package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.IceAbility;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.IceLoot;
import java.util.Arrays;
import java.util.List;

public class IceEnemyFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        return Arrays.asList(new IceAbility("Frost Nova"), new IceAbility("Ice Shield"));
    }

    @Override
    public LootTable createLootTable() {
        return new IceLoot();
    }

    @Override
    public String createAIBehavior() {
        return "DEFENSIVE";
    }
}
