package com.narxoz.rpg.builder;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
public class Director {

    public Enemy constructLegendaryDragon(BossBuilder builder, EnemyComponentFactory factory) {
        return builder.setName("Legendary World Eater")
                .setStats(100000, 2000, 800, 50)
                .setDragonSpecs("Ancient", true)
                .addPhase(1, 100000)
                .addPhase(2, 50000)
                .addPhase(3, 10000)
                .applyTheme(factory) //
                .build();
    }

    public Enemy constructEliteGuardian(EnemyBuilder builder, EnemyComponentFactory factory) {
        return builder.setName("Elite Palace Guard")
                .setStats(5000, 150, 100, 60)
                .applyTheme(factory)
                .build();
    }
}