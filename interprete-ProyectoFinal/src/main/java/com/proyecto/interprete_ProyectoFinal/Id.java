package com.proyecto.interprete_ProyectoFinal;

public class Id {
    private String nombre;
    private String tipo;
    private boolean usado;
    private boolean inicializado;

    public Id(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.usado = false;
        this.inicializado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public boolean isInicializado() {
        return inicializado;
    }

    public void setInicializado(boolean inicializado) {
        this.inicializado = inicializado;
    }

    @Override
    public String toString() {
        return "Id{" +
               "nombre='" + nombre + '\'' +
               ", tipo='" + tipo + '\'' +
               ", usado=" + usado +
               ", inicializado=" + inicializado +
               '}';
    }
}
