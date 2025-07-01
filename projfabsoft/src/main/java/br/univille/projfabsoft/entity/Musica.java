     package br.univille.projfabsoft.entity;

     import jakarta.persistence.*;

     @Entity
     public class Musica {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private long id;
         private String nome;
         @Column(columnDefinition = "CLOB")
         private String mp3Data;

         public Long getId() { return id; }
         public void setId(long id) { this.id = id; }
         public String getNome() { return nome; }
         public void setNome(String nome) { this.nome = nome; }
         public String getMp3Data() { return mp3Data; }
         public void setMp3Data(String mp3Data) { this.mp3Data = mp3Data; }
     }