package com.example.demo.controller;

import com.example.demo.model.ItemMagico;
import com.example.demo.model.Personagem;
import com.example.demo.service.PersonagemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemService service;

    public PersonagemController(PersonagemService service) {
        this.service = service;
    }

    @PostMapping
    public Personagem criar(@RequestBody Personagem p) {
        return service.criar(p);
    }

    @GetMapping
    public List<Personagem> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Personagem buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }

    @PutMapping("/{id}/nome")
    public Personagem atualizarNome(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        String novoNome = payload.get("nome");
        return service.atualizarNome(id, novoNome);
    }

    @PutMapping("/{id}/nome-aventureiro")
    public Personagem atualizarNomeAventureiro(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        String novoNome = payload.get("nomeAventureiro");
        return service.atualizarNomeAventureiro(id, novoNome);
    }

    @PostMapping("/{idPersonagem}/itens/{idItem}")
    public Personagem adicionarItem(@PathVariable Long idPersonagem, @PathVariable Long idItem) {
        return service.adicionarItem(idPersonagem, idItem);
    }

    @DeleteMapping("/{idPersonagem}/itens/{idItem}")
    public void removerItem(@PathVariable Long idPersonagem, @PathVariable Long idItem) {
        service.removerItem(idPersonagem, idItem);
    }

    @GetMapping("/{id}/itens")
    public List<ItemMagico> listarItens(@PathVariable Long id) {
        return service.listarItens(id);
    }

    @GetMapping("/{id}/amuleto")
    public ItemMagico buscarAmuleto(@PathVariable Long id) {
        return service.buscarAmuleto(id);
    }
}