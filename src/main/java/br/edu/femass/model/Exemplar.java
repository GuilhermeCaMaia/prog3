package br.edu.femass.model;

import java.time.LocalDate;

public class Exemplar {
    private Long codigo;
    private Long proximoNumero = 1l;
    private LocalDate dataAquisicao;

    public Exemplar(Long codigo, LocalDate dataAquisicao) {
        this.codigo = proximoNumero;
        proximoNumero ++;
        this.dataAquisicao = dataAquisicao;
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
}
