package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nomeAventureiro;
    private String classeAventureiro;
    private int level;
    private Itens items;
    private int forca;
    private int defesa;

    public Personagem(String nome, String nomeAventureiro, String classeAventureiro, int level, Itens items, int forca, int defesa) {
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classeAventureiro = classeAventureiro;
        this.level = level;
        this.items = items;
        this.forca = forca;
        this.defesa = defesa;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
