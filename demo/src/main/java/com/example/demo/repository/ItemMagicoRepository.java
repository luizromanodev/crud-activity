package com.example.demo.repository;

import com.example.demo.model.ItemMagico;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemMagicoRepository {
    private Map<Long, ItemMagico> banco = new HashMap<>();
    private Long idAtual = 1L;

    public ItemMagico salvar(ItemMagico item) {
        item.setId(idAtual++);
        banco.put(item.getId(), item);
        return item;
    }

    public List<ItemMagico> listarTodos() {
        return new ArrayList<>(banco.values());
    }

    public Optional<ItemMagico> buscarPorId(Long id) {
        return Optional.ofNullable(banco.get(id));
    }

    public void remover(Long id) {
        banco.remove(id);
    }
}
