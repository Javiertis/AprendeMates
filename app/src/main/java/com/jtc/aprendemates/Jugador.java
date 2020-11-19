package com.jtc.aprendemates;

import java.io.Serializable;

public class Jugador implements Serializable {
    private final String nombre;
    private int score;
    private Nivel dificultad;
    private int vidas;

    public Jugador(String nombre, String dificultad, int vidas, int score) {
        this.nombre = nombre;
        this.dificultad = Nivel.valueOf(dificultad);
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

    public int getVidas() {
        return vidas;
    }

    public void reducirVidas() {
        vidas--;
    }

    @Override
    public String toString() {
        return this.nombre + System.lineSeparator()
                + this.score;
    }
}
