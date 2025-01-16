package com.tarefas.lista.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class Users{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column( nullable = true)
    private String fullName;
    
    @NotBlank(message = "O nome de uruario é obrigatorio")
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false)
    private String password;
}

