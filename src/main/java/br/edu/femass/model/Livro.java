package br.edu.femass.model;

import br.edu.femass.Dao.DaoLivro;

import java.util.List;
import java.util.Objects;

public class Livro {
    private Long codigo;
    private String titulo;
    private Long proximoNumero = 1l;
    private Autor autor;

    public  Livro(){

    }
    public Livro(String titulo, Autor autor) throws Exception {
        this.titulo = titulo;
        this.autor = autor;
        proximoCodigo();
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

    public String toString(){return this.titulo.toString() + " " + this.codigo;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return codigo.equals(livro.codigo) && titulo.equals(livro.titulo) && autor.equals(livro.autor);
    }
    //
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Livro livro = (Livro) o;
//        return Objects.equals(codigo, livro.codigo) && Objects.equals(titulo, livro.titulo) && Objects.equals(proximoNumero, livro.proximoNumero) && Objects.equals(autor, livro.autor);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, titulo, proximoNumero, autor);
    }//

    public void proximoCodigo() throws Exception {
        Long maior = 0L;

        List<Livro> livros = new DaoLivro().getAll();
        for (Livro livro : livros) {
            if (livro.getCodigo() > maior) {
                maior = livro.getCodigo();
                setCodigo(maior + 1);
            }
        }
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
