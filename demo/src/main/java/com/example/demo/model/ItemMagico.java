package com.example.demo.model;

import com.example.demo.enums.TipoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemMagico {
    private Long id;
    private String nome;
    private TipoItem tipo;
    private int forca;
    private int defesa;
}
