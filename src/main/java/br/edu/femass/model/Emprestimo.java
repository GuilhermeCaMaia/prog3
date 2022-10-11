package br.edu.femass.model;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolicao;
    private LocalDate dataDevolucao;

    public Emprestimo(LocalDate dataEmprestimo, LocalDate dataPrevistaDevolicao, LocalDate dataDevolucao) {
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
}
