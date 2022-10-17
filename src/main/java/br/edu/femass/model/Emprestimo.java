package br.edu.femass.model;

import br.edu.femass.Dao.DaoAluno;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolicao;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Leitor Aluno;
    private Professor professor;
    public Emprestimo(){

    }
    public Emprestimo( Livro livro, Aluno aluno ) {
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolicao = LocalDate.now().plusDays(aluno.getPrazoMaximoDevolucao());
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
        this.Aluno = aluno;
    }
    public Emprestimo( Livro livro, Professor professor ) {
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolicao = LocalDate.now().plusDays(professor.getPrazoMaximoDevolucao());
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
        this.professor = professor;
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
        this.dataDevolucao = LocalDate.now();
    }
    public void setDataPrevistaDevolicao(LocalDate dataPrevistaDevolicao) {
        this.dataPrevistaDevolicao = dataPrevistaDevolicao;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getAluno() {
        return Aluno;
    }
    public Professor getProfessor() {
        return professor;
    }

    public String toString(){
        return this.livro.getTitulo()+" "+this.dataPrevistaDevolicao;
    }
}
