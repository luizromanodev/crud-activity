package com.example.demo.controller;

import com.example.demo.model.ItemMagico;
import com.example.demo.service.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemMagicoController {

    private final ItemMagicoService service;

    public ItemMagicoController(ItemMagicoService service) {
        this.service = service;
    }

    @PostMapping
    public ItemMagico criar(@RequestBody ItemMagico item) {
        return service.criar(item);
    }

    @GetMapping
    public List<ItemMagico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ItemMagico buscar(@PathVariable Long id) {
        return service.buscar(id);
    }
}
