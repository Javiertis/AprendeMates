package com.jtc.aprendemates;

public class Jugador {
    private final String nombre;
    private int score = 0;
    private Nivel dificultad;
    private int vidas;

    public Jugador(String nombre, String dificultad) {
        this.nombre = nombre;
        this.dificultad = Nivel.valueOf(dificultad);
        this.vidas = 3;
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
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", score=" + score +
                ", dificultad=" + dificultad +
                '}';
    }
}
