package com.narxoz.rpg;

import com.narxoz.rpg.builder.BossBuilder;
import com.narxoz.rpg.builder.Director;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireEnemyFactory;
import com.narxoz.rpg.factory.IceEnemyFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns ===\n");

        System.out.println("PART 1: ABSTRACT FACTORY");
        EnemyComponentFactory fireFactory = new FireEnemyFactory();
        EnemyComponentFactory iceFactory = new IceEnemyFactory();

        System.out.println("Fire Theme: " + fireFactory.createAbilities().size() + " abilities, AI: " + fireFactory.createAIBehavior());
        System.out.println("Ice Theme:  " + iceFactory.createAbilities().size() + " abilities, AI: " + iceFactory.createAIBehavior());

        System.out.println("\nPART 2: BUILDER & DIRECTOR");
        Director director = new Director();

        DragonBoss fireDragon = (DragonBoss) new BossBuilder()
                .setName("Ancient Fire Drake")
                .setStats(50000, 500, 200, 50)
                .setDragonSpecs("FIRE", true)
                .addPhase(1, 50000)
                .addPhase(2, 25000)
                .applyTheme(fireFactory)
                .build();

        fireDragon.displayInfo();

        Enemy presetIceDragon = director.constructDragon(new BossBuilder(), iceFactory);
        presetIceDragon.displayInfo();

        System.out.println("\nPART 3: PROTOTYPE");
        Goblin baseGoblin = new Goblin("Forest Goblin");
        baseGoblin.setLootTable(fireFactory.createLootTable());

        Goblin eliteGoblin = baseGoblin.clone();
        eliteGoblin.setName("Elite Fire-Blessed Goblin");
        eliteGoblin.multiplyStats(2.5);

        System.out.println("Original: " + baseGoblin.getName() + " [HP: " + baseGoblin.getHealth() + "]");
        System.out.println("Clone:    " + eliteGoblin.getName() + " [HP: " + eliteGoblin.getHealth() + "]");

        System.out.println("\nPART 4: FULL PIPELINE");
        EnemyComponentFactory shadowTheme = new IceEnemyFactory();

        Enemy template = new BossBuilder()
                .setName("Shadow Lord Template")
                .setStats(20000, 300, 150, 40)
                .applyTheme(shadowTheme)
                .build();

        for (int i = 1; i <= 2; i++) {
            Enemy minion = template.clone();
            minion.setName("Shadow Minion #" + i);
            minion.displayInfo();
        }

        System.out.println("\n=== Patterns Demonstrated ===");
        System.out.println("- Abstract Factory");
        System.out.println("- Builder");
        System.out.println("- Factory Method (in build())");
        System.out.println("- Prototype");
    }
}