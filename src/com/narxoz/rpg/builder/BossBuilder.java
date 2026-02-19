package com.narxoz.rpg.builder;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import java.util.HashMap;
import java.util.Map;
public class BossBuilder implements EnemyBuilder {
    private DragonBoss boss;
    private Map<Integer, Integer> tempPhases = new HashMap<>();
    public BossBuilder() {
        this.boss = new DragonBoss();
    }
    @Override
    public EnemyBuilder setName(String name) {
        boss.setName(name);
        return this;
    }

    @Override
    public EnemyBuilder setStats(int hp, int dmg, int def, int spd) {
        boss.setHealth(hp);
        boss.setDamage(dmg);
        boss.setDefense(def);
        boss.setSpeed(spd);
        return this;
    }

    public BossBuilder addPhase(int phaseNumber, int healthThreshold) {
        tempPhases.put(phaseNumber, healthThreshold);
        return this;
    }

    public BossBuilder setDragonSpecs(String element, boolean canFly) {
        boss.setElement(element);
        boss.setCanFly(canFly);
        return this;
    }

    @Override
    public EnemyBuilder applyTheme(EnemyComponentFactory factory) {
        boss.setAbilities(factory.createAbilities());
        boss.setLootTable(factory.createLootTable());
        boss.setAiBehavior(factory.createAIBehavior());
        return this;
    }

    @Override
    public Enemy build() {
        if (boss.getName() == null) throw new IllegalStateException("Boss must have a name!");

        boss.setPhases(tempPhases);
        return boss;
    }
}
