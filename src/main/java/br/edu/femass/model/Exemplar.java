package br.edu.femass.model;

import br.edu.femass.Dao.DaoLivro;

import java.time.LocalDate;
import java.util.List;

public class Exemplar {
    private Long codigo;
    private Long proximoNumero = 1l;
    private LocalDate dataAquisicao;


    public Exemplar() throws Exception {
        proximoCodigo();
        proximoNumero ++;
        this.dataAquisicao = LocalDate.now();
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
}
