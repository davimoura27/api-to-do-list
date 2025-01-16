package com.tarefas.lista.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tarefas.lista.entity.Users;

import com.tarefas.lista.repository.UserRepository;

@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(Users users){

     users.setPassword(passwordEncoder.encode(users.getPassword()));

       userRepository.save(users);
    }
}
