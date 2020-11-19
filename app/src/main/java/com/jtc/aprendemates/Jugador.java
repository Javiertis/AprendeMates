package com.jtc.aprendemates;

import java.io.Serializable;

public class Jugador implements Serializable {
    private final String nombre;
    private int score;
    private Nivel dificultad;
    private final Nivel nivelInicial;
    private int vidas;

    public Jugador(String nombre, String dificultad, int vidas, int score) {
        this.nombre = nombre;
        this.dificultad = Nivel.valueOf(dificultad);
        this.nivelInicial = Nivel.valueOf(dificultad);
        this.vidas = vidas;
        this.score = score;
    }

    public String getNombre() {
        return nombre;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Nivel getDificultad() {
        return dificultad;
    }

    public void setDificultad(Nivel dificultad) {
        this.dificultad = dificultad;
    }

    public void aumentarDificultad() {
        if (this.dificultad == Nivel.FACIL) this.dificultad = Nivel.MEDIO;
        if (this.dificultad == Nivel.MEDIO) this.dificultad = Nivel.DIFICIL;
    }

    public int getVidas() {
        return vidas;
    }

    public void reducirVidas() {
        vidas--;
    }

    public Nivel getNivelInicial() {
        return nivelInicial;
    }

    @Override
    public String toString() {
        return this.nombre + System.lineSeparator()
                + this.score;
    }
}
