package br.edu.femass.model;

import java.util.Objects;

public class Livro {
    private Long codigo;
    private String titulo;
    private Long proximoNumero = 1l;
    private Autor autor;

    public  Livro(){

    }
    public Livro(String titulo, Autor autor) {
        this.codigo = proximoNumero;
        proximoNumero ++;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getProximoNumero() {
        return proximoNumero;
    }

    public Autor getAutor() {
        return autor;
    }

    public String toString(){return this.titulo.toString();}
//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(codigo, livro.codigo) && Objects.equals(titulo, livro.titulo) && Objects.equals(proximoNumero, livro.proximoNumero) && Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, titulo, proximoNumero, autor);
    }//
}
