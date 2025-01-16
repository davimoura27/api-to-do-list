package com.tarefas.lista.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tarefas.lista.classe.Tarefa;


public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    
}
