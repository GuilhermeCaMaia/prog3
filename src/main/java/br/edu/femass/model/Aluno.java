package br.edu.femass.model;

public class Aluno extends Leitor{
    private String matricula;

    public Aluno(){

    }
    public Aluno(String nome, String endereco, String telefone, String matricula) {
        super(nome, endereco, telefone);
        this.matricula = matricula;
        setPrazoMaximoDevolucao(15);
    }

    public String getMatricula() {
        return matricula;
    }

    public String toString(){
        return this.getNome();
    }
}
