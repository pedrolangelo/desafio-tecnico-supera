package com.example.gerenciamento_tarefas.service;

import com.example.gerenciamento_tarefas.Model.ItemModel;
import com.example.gerenciamento_tarefas.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemModel> findByDataInicio(LocalDate dataInicio) {
        return itemRepository.findByDataInicio(dataInicio);
    }

    public List<ItemModel> findByPrioridade(Boolean prioridade) {
        return itemRepository.findByPrioridade(prioridade);
    }

    public List<ItemModel> findByFinalizado(Boolean finalizado) {
        return itemRepository.findByFinalizado(finalizado);
    }

    public List<ItemModel> findByDataInicioAndPrioridade(LocalDate dataInicio, Boolean prioridade) {
        return itemRepository.findByDataInicioAndPrioridade(dataInicio, prioridade);
    }

    public List<ItemModel> findByDataInicioAndFinalizado(LocalDate dataInicio, Boolean finalizado) {
        return itemRepository.findByDataInicioAndFinalizado(dataInicio, finalizado);
    }

    public List<ItemModel> findByPrioridadeAndFinalizado(Boolean prioridade, Boolean finalizado) {
        return itemRepository.findByPrioridadeAndFinalizado(prioridade, finalizado);
    }

    public List<ItemModel> findByDataInicioAndPrioridadeAndFinalizado(LocalDate dataInicio, Boolean prioridade, Boolean finalizado) {
        return itemRepository.findByDataInicioAndPrioridadeAndFinalizado(dataInicio, prioridade, finalizado);
    }
}
