package br.edu.femass.model;

import br.edu.femass.Dao.DaoLivro;

import java.time.LocalDate;
import java.util.List;

public class Exemplar {
    private Long codigo;
    private Long proximoNumero = 1l;
    private LocalDate dataAquisicao;
    private Livro livro;

    public Exemplar(){

    }
    public Exemplar(Livro livro ) throws Exception {
        proximoCodigo();
        proximoNumero ++;
        this.dataAquisicao = LocalDate.now();
        this.livro = livro;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Long getProximoNumero() {
        return proximoNumero;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = LocalDate.now();
    }

    public void proximoCodigo() throws Exception { // trocar variavel de todos os proximoCodigo
        Long maior = 0L;

        List<Livro> livros = new DaoLivro().getAll();
        for (Livro livro : livros) {
            if (livro.getCodigo() > maior) {
                maior = livro.getCodigo();
                setCodigo(maior + 1);
            }
        }
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String toString(){
        return getLivro().getAutor().getNome() +" "+ getLivro().getTitulo();
    }
}
