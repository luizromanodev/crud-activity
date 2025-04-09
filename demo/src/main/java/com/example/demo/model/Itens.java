package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Itens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeItem;
    private String tipoItem;
    private int forca;
    private int defesa;

    public Itens(String nomeItem, String tipoItem, int forca, int defesa) {
        this.nomeItem = nomeItem;
        this.tipoItem = tipoItem;
        this.forca = forca;
        this.defesa = defesa;
    }
}
