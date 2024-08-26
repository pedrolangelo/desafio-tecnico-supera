package com.example.gerenciamento_tarefas.service;

import org.springframework.stereotype.Service;

@Service
public class ListaService {
    public String listas(String name){
        return "lista " + name;
    }
}
