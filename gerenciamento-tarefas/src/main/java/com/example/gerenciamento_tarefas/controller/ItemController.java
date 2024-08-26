package com.example.gerenciamento_tarefas.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciamento_tarefas.Model.ItemModel;
import com.example.gerenciamento_tarefas.Repository.ItemRepository;
import com.example.gerenciamento_tarefas.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ItemService itemService;

    @CrossOrigin(origins = "http://localhost:3000")

    @GetMapping
    public List<ItemModel> getItem() {
        return repository.findAll();
    }

    @GetMapping("/filter/dataInicio")
    public List<ItemModel> getByDataInicio(@RequestParam LocalDate dataInicio) {
        return itemService.findByDataInicio(dataInicio);
    }

    @GetMapping("/filter/prioridade")
    public List<ItemModel> getByPrioridade(@RequestParam Boolean prioridade) {
        return itemService.findByPrioridade(prioridade);
    }

    @GetMapping("/filter/finalizado")
    public List<ItemModel> getByFinalizado(@RequestParam Boolean finalizado) {
        return itemService.findByFinalizado(finalizado);
    }

    @GetMapping("/filter/dataInicioAndPrioridade")
    public List<ItemModel> getByDataInicioAndPrioridade(@RequestParam LocalDate dataInicio, @RequestParam Boolean prioridade) {
        return itemService.findByDataInicioAndPrioridade(dataInicio, prioridade);
    }

    @GetMapping("/filter/dataInicioAndFinalizado")
    public List<ItemModel> getByDataInicioAndFinalizado(@RequestParam LocalDate dataInicio, @RequestParam Boolean finalizado) {
        return itemService.findByDataInicioAndFinalizado(dataInicio, finalizado);
    }

    @GetMapping("/filter/prioridadeAndFinalizado")
    public List<ItemModel> getByPrioridadeAndFinalizado(@RequestParam Boolean prioridade, @RequestParam Boolean finalizado) {
        return itemService.findByPrioridadeAndFinalizado(prioridade, finalizado);
    }

    @GetMapping("/filter/dataInicioAndPrioridadeAndFinalizado")
    public List<ItemModel> getByDataInicioAndPrioridadeAndFinalizado(@RequestParam LocalDate dataInicio, @RequestParam Boolean prioridade, @RequestParam Boolean finalizado) {
        return itemService.findByDataInicioAndPrioridadeAndFinalizado(dataInicio, prioridade, finalizado);
    }

    @PostMapping
    public ResponseEntity<ItemModel> createItem(@RequestBody ItemModel newItem) {
        ItemModel savedItem = repository.save(newItem);
        return ResponseEntity.ok(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemModel> updateItem(@PathVariable Long id, @RequestBody ItemModel updatedItem) {
        Optional<ItemModel> optionalItem = repository.findById(id);
        if (optionalItem.isPresent()) {
            ItemModel existingItem = optionalItem.get();
            existingItem.setTitulo(updatedItem.getTitulo());
            existingItem.setDataInicio(updatedItem.getDataInicio());
            existingItem.setDataFim(updatedItem.getDataFim());
            existingItem.setPrioridade(updatedItem.getPrioridade());
            existingItem.setFinalizado(updatedItem.getFinalizado());
            repository.save(existingItem);
            return ResponseEntity.ok(existingItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        Optional<ItemModel> optionalItem = repository.findById(id);
        if (optionalItem.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}