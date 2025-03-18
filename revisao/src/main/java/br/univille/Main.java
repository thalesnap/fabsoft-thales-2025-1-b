package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Cliente;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Cidade joinville = new Cidade();
        joinville.setNome("Joinville");
        joinville.setEstado("Santa Catarina");

        Cliente zezinho = new Cliente("Zezinho");
        zezinho.setNome("Zezinho da silva Sauro");
        zezinho.setCidade(joinville);


        Cliente mariazinha = new Cliente();
        mariazinha.setNome("Mariazinha");

        System.out.println(zezinho);
        System.out.println(mariazinha);
    }
}