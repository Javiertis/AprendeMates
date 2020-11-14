package com.jtc.aprendemates;

public class Jugador {
    private String nombre;
    private int score;
    private Nivel dificultad;

    public Jugador(String nombre, String dificultad) {
        this.nombre = nombre;
        this.dificultad = Nivel.valueOf(dificultad);
        this.score = 0;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
