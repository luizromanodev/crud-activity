package com.example.demo.repository;

import com.example.demo.model.Personagem;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonagemRepository {
    private Map<Long, Personagem> banco = new HashMap<>();
    private Long idAtual = 1L;

    public Personagem salvar(Personagem personagem) {
        personagem.setId(idAtual++);
        banco.put(personagem.getId(), personagem);
        return personagem;
    }

    public List<Personagem> listarTodos() {
        return new ArrayList<>(banco.values());
    }

    public Optional<Personagem> buscarPorId(Long id) {
        return Optional.ofNullable(banco.get(id));
    }

    public void remover(Long id) {
        banco.remove(id);
    }

    public void atualizar(Personagem personagem) {
        banco.put(personagem.getId(), personagem);
    }
}
