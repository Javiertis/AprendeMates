package com.jtc.aprendemates;

import java.io.Serializable;

public class Player implements Serializable {
    private final String name;
    private int score;
    private final Level initLevel;
    private Level actualLevel;
    private int life;
    private int bonus;

    public Player(String name, String actualLevel, int life, int score) {
        this.name = name;
        this.actualLevel = Level.valueOf(actualLevel);
        this.initLevel = Level.valueOf(actualLevel);
        this.life = life;
        this.score = score;
        this.bonus = 1;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }


    public void scoreUp() {
        this.score += 5 * (this.bonus);
    }

    public void bonusUp() {
        this.bonus++;
    }

    public Level getActualLevel() {
        return actualLevel;
    }

    public void levelUp() {
        if (this.actualLevel == Level.EASY) this.actualLevel = Level.MEDIUM;
        if (this.actualLevel == Level.MEDIUM) this.actualLevel = Level.HARD;
    }

    public int getLife() {
        return life;
    }

    public void lifeDown() {
        life--;
    }

    public Level getInitLevel() {
        return initLevel;
    }

    @Override
    public String toString() {
        return this.name + System.lineSeparator()
                + this.score;
    }
}
