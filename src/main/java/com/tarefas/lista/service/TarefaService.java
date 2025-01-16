package com.tarefas.lista.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefas.lista.classe.Tarefa;
import com.tarefas.lista.repository.TarefaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service

public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa create(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);

    }
    public List<Tarefa> getList(){
        List<Tarefa>tarefa = tarefaRepository.findAll();
        return tarefa.stream().toList();
    }

    public Tarefa getById(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa com o ID" + id + "não encontrada"));
    }

    public Tarefa update(Long id, Tarefa tarefaUpdate) {
        Optional<Tarefa> tarefasExistentes = tarefaRepository.findById(id);

        if (tarefasExistentes.isPresent()) {
            Tarefa tarefa = tarefasExistentes.get();

            tarefa.setTitulo(tarefaUpdate.getTitulo());
            tarefa.setDescricao(tarefaUpdate.getDescricao());
            tarefa.setStatus(tarefaUpdate.getStatus());
            tarefa.setData(tarefaUpdate.getData());

            return tarefaRepository.save(tarefa);
        } else {
            throw new RuntimeException("Tarefa com o Id" + id + "não encontrada");
        }

    }

    public void delete(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa com o Id" + id + "não encontrada");
        }

        tarefaRepository.deleteById(id);
    }

}
