package com.example.demo.model;

import com.example.demo.enums.Classe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personagem {
    private Long id;
    private String nome;
    private String nomeAventureiro;
    private Classe classe;
    private int forca;
    private int defesa;
    private int level = 1;

    private List<ItemMagico> itensMagicos = new ArrayList<>();
    private ItemMagico amuleto;

    public int getForcaTotal() {
        int bonus = itensMagicos.stream().mapToInt(ItemMagico::getForca).sum();
        return forca + bonus;
    }

    public int getDefesaTotal() {
        int bonus = itensMagicos.stream().mapToInt(ItemMagico::getDefesa).sum();
        return defesa + bonus;
    }
}