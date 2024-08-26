package com.example.gerenciamento_tarefas.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciamento_tarefas.Model.ListaModel;
import com.example.gerenciamento_tarefas.Repository.ListaRepository;

@RestController
@RequestMapping("lista")
public class ListaController {

    @Autowired
    private ListaRepository repository;

    @CrossOrigin(origins = "http://localhost:3000")

    @GetMapping
    public List<ListaModel> getLista() {
        List<ListaModel> getListas = repository.findAll();
        return getListas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaModel> getListaById(@PathVariable Long id) {
        Optional<ListaModel> optionalLista = repository.findById(id);
        if (optionalLista.isPresent()) {
            return ResponseEntity.ok(optionalLista.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ListaModel> createLista(@RequestBody ListaModel newLista) {
        ListaModel savedLista = repository.save(newLista);
        return ResponseEntity.ok(savedLista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaModel> updateLista(@PathVariable Long id, @RequestBody ListaModel updatedLista) {
        Optional<ListaModel> optionalLista = repository.findById(id);
        if (optionalLista.isPresent()) {
            ListaModel existingLista = optionalLista.get();
            existingLista.setTitulo(updatedLista.getTitulo());
            repository.save(existingLista);
            return ResponseEntity.ok(existingLista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long id) {
        Optional<ListaModel> optionalLista = repository.findById(id);
        if (optionalLista.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}