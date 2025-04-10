package com.example.demo.service;

import com.example.demo.enums.TipoItem;
import com.example.demo.model.ItemMagico;
import com.example.demo.repository.ItemMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemMagicoService {

    private final ItemMagicoRepository repo;

    public ItemMagicoService(ItemMagicoRepository repo) {
        this.repo = repo;
    }

    public ItemMagico criar(ItemMagico item) {
        if (item.getForca() > 10 || item.getDefesa() > 10) {
            throw new RuntimeException("Força ou defesa não podem passar de 10.");
        }
        if (item.getForca() == 0 && item.getDefesa() == 0) {
            throw new RuntimeException("Item precisa de pelo menos 1 ponto de força ou defesa.");
        }
        if (item.getTipo() == TipoItem.ARMA && item.getDefesa() != 0) {
            throw new RuntimeException("Armas não podem ter defesa.");
        }
        if (item.getTipo() == TipoItem.ARMADURA && item.getForca() != 0) {
            throw new RuntimeException("Armaduras não podem ter força.");
        }
        return repo.salvar(item);
    }

    public List<ItemMagico> listar() {
        return repo.listarTodos();
    }

    public ItemMagico buscar(Long id) {
        return repo.buscarPorId(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }
}
