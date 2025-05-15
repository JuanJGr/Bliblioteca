package org.example.model;

public class Libro {
    protected int id;
    protected String titulo;
    protected String genero;
    protected int autorId;

    public Libro() {
    }

    public Libro(int id, String titulo, String genero, int autorId) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.autorId = autorId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getAutorId() { return autorId; }
    public void setAutorId(int autorId) { this.autorId = autorId; }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", autorId=" + autorId +
                '}';
    }
}
