package org.example.model;

import java.time.LocalDate;

public class Miembro {
    protected int id;
    protected String nombre;
    protected String apellido;
    protected LocalDate fechaInscripcion;

    public Miembro() {
    }

    public Miembro(int id, String nombre, String apellido, LocalDate fechaInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }

    @Override
    public String toString() {
        return "Miembro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaInscripcion=" + fechaInscripcion +
                '}';
    }
}
