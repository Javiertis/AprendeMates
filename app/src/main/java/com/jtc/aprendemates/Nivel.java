package com.jtc.aprendemates;

public enum Nivel {

    FACIL(0), MEDIO(1), DIFICIL(2);

    private final int nivel;

    Nivel(int d) {
        this.nivel = d;
    }

    public int getNivel() {
        return nivel;
    }
}
