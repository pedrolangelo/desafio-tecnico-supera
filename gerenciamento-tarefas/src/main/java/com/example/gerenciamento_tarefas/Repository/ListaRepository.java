package com.example.gerenciamento_tarefas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciamento_tarefas.Model.ListaModel;

public interface ListaRepository extends JpaRepository<ListaModel, Long>{
}
