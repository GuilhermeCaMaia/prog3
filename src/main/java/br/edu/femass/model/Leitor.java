package br.edu.femass.model;

public class Leitor {
    private Long Codigo;
    private Long proximoNumero = 1l;
    private String nome;
    private String endereco;
    private String telefone;
    private int prazoMaximoDevolucao;

    public Leitor(String nome, String endereco, String telefone, int prazoMaximoDevolucao) {
        this.Codigo = proximoNumero;
        proximoNumero ++;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }

    public Long getCodigo() {
        return Codigo;
    }

    public Long getProximoNumero() {
        return proximoNumero;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }
}
