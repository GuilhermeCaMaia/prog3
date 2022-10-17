package br.edu.femass.model;

import br.edu.femass.Dao.DaoAluno;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolicao;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Leitor leitor;
    public Emprestimo(){

    }
    public Emprestimo( Livro livro, Leitor leitor) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolicao = dataPrevistaDevolicao;
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolicao() {
        return dataPrevistaDevolicao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = LocalDate.now();
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public void setDataPrevistaDevolicao(LocalDate dataPrevistaDevolicao) {
        this.dataPrevistaDevolicao = LocalDate.now().plusDays(15);
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }


}
