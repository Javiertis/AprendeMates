package com.jtc.aprendemates;

public enum Level {

    EASY(0), MEDIUM(1), HARD(2);

    private final int levelValue;

    Level(int d) {
        this.levelValue = d;
    }

    public int levelValue() {
        return levelValue;
    }
}
