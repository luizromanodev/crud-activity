package com.example.demo.service;

import com.example.demo.enums.Classe;
import com.example.demo.enums.TipoItem;
import com.example.demo.model.ItemMagico;
import com.example.demo.model.Personagem;
import com.example.demo.repository.ItemMagicoRepository;
import com.example.demo.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepo;
    private final ItemMagicoRepository itemRepo;

    public PersonagemService(PersonagemRepository personagemRepo, ItemMagicoRepository itemRepo) {
        this.personagemRepo = personagemRepo;
        this.itemRepo = itemRepo;
    }

    public Personagem criar(Personagem p) {
        if (p.getForca() + p.getDefesa() > 10) {
            throw new RuntimeException("A soma de Força e Defesa não pode passar de 10.");
        }
        return personagemRepo.salvar(p);
    }

    public List<Personagem> listar() {
        return personagemRepo.listarTodos();
    }

    public Personagem buscar(Long id) {
        return personagemRepo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
    }

    public void remover(Long id) {
        personagemRepo.remover(id);
    }

    public Personagem atualizarNome(Long id, String novoNome) {
        Personagem personagem = buscar(id);
        personagem.setNome(novoNome);
        return personagem;
    }

    public Personagem atualizarNomeAventureiro(Long id, String nomeAventureiro) {
        Personagem p = buscar(id);
        p.setNomeAventureiro(nomeAventureiro);
        personagemRepo.atualizar(p);
        return p;
    }

    public Personagem adicionarItem(Long idPersonagem, Long idItem) {
        Personagem p = buscar(idPersonagem);
        ItemMagico item = itemRepo.buscarPorId(idItem)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        if (item.getTipo() == TipoItem.AMULETO) {
            if (p.getAmuleto() != null) {
                throw new RuntimeException("Personagem já possui um amuleto.");
            }
            p.setAmuleto(item);
        } else {
            p.getItensMagicos().add(item);
        }

        personagemRepo.atualizar(p);
        return p;
    }

    public void removerItem(Long idPersonagem, Long idItem) {
        Personagem p = buscar(idPersonagem);
        if (p.getAmuleto() != null && p.getAmuleto().getId().equals(idItem)) {
            p.setAmuleto(null);
        } else {
            p.getItensMagicos().removeIf(item -> item.getId().equals(idItem));
        }
        personagemRepo.atualizar(p);
    }

    public List<ItemMagico> listarItens(Long idPersonagem) {
        Personagem p = buscar(idPersonagem);
        List<ItemMagico> todos = p.getItensMagicos();
        if (p.getAmuleto() != null) todos.add(p.getAmuleto());
        return todos;
    }

    public ItemMagico buscarAmuleto(Long idPersonagem) {
        Personagem p = buscar(idPersonagem);
        return p.getAmuleto();
    }
}
