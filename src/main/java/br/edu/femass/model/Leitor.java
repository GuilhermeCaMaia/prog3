package br.edu.femass.model;

import br.edu.femass.Dao.DaoAluno;
import br.edu.femass.Dao.DaoLeitor;

import java.time.LocalDate;
import java.util.List;

public class Leitor {
    private Long Codigo;
    private Long proximoNumero = 1l;
    private String nome;
    private String endereco;
    private String telefone;
    private int prazoMaximoDevolucao;
    private Aluno aluno;
    private Professor professor;

    public Leitor(){

    }
    public Leitor(String nome, String endereco, String telefone) {
        this.Codigo = proximoNumero;
        proximoNumero ++;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        setPrazoMaximoDevolucao(15);
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

    public Aluno getAluno() {
        return aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void proximoCodigo() throws Exception {
        Long maior = 0L;

        List<Leitor> leitors = new DaoLeitor().getAll();
        for (Leitor leitor : leitors){
            if(leitor.getCodigo() > maior){
                maior = leitor.getCodigo();
                setCodigo(maior +1);
            }
        }
    }

    public void setCodigo(Long codigo) {
        Codigo = codigo;
    }

    public void setPrazoMaximoDevolucao(int prazoMaximoDevolucao) {
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }

    public String toString(){
        return this.getNome();
    }
}
