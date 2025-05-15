package org.example.model;

import java.time.LocalDate;

public class Prestamo {
    protected int libroId;
    protected int miembroId;
    protected LocalDate fechaPrestamo;
    protected LocalDate fechaDevolucion;

    public Prestamo() {
    }

    public Prestamo(int libroId, int miembroId, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libroId = libroId;
        this.miembroId = miembroId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getLibroId() { return libroId; }
    public void setLibroId(int libroId) { this.libroId = libroId; }

    public int getMiembroId() { return miembroId; }
    public void setMiembroId(int miembroId) { this.miembroId = miembroId; }

    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(LocalDate fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libroId=" + libroId +
                ", miembroId=" + miembroId +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}