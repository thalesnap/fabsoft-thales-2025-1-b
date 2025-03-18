package br.univille;

public class Cliente {
    //variável - atributo
    private String nome;

    //construtor = mesmo nome da classe e sem um retorno
    // func = inicializar atributos
    // obrigar a passagem de valores
    public Cliente(String nome) {
        this.nome = nome;
    }
    //polimorfismo - varias formas de existir a mesma coisa
    public Cliente(){
    
    }

    //método
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    // encapsulamento = responder a implementacao dentro do objeto
}