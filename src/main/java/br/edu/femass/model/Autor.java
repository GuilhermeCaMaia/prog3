package br.edu.femass.model;

public class Autor {
    private String nome;
    private String sobrenome;
    private String nacionalidade;

    public Autor(){

    }
    public Autor(String nome, String sobrenome, String nacionalidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    //Faz o formato da lista
    public String toString(){
        return this.nome + " " + this.sobrenome;
    }
}
