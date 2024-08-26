package com.example.gerenciamento_tarefas.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciamento_tarefas.Model.ItemModel;

public interface ItemRepository extends JpaRepository<ItemModel, Long>{
    List<ItemModel> findByPrioridade(Boolean prioridade);
    
    List<ItemModel> findByDataInicio(LocalDate dataInicio);
    
    List<ItemModel> findByFinalizado(Boolean finalizado);

    List<ItemModel> findByDataInicioAndPrioridade(LocalDate dataInicio, Boolean prioridade);

    List<ItemModel> findByDataInicioAndFinalizado(LocalDate dataInicio, Boolean finalizado);

    List<ItemModel> findByPrioridadeAndFinalizado(Boolean prioridade, Boolean finalizado);

    List<ItemModel> findByDataInicioAndPrioridadeAndFinalizado(LocalDate dataInicio, Boolean prioridade, Boolean finalizado);
}