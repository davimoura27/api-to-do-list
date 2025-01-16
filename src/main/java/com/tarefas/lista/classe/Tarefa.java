package com.tarefas.lista.classe;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String titulo;

    @Column(name = "description", length = 500)
    private String descricao;

    @Column(name = "status", nullable = false)
    private String status;

    private LocalDate data;
}
