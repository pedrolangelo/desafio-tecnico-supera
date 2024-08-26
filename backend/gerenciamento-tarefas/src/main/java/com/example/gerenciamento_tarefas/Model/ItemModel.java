package com.example.gerenciamento_tarefas.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "item")
@Entity(name = "item")
@Getter
@Setter
public class ItemModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Boolean prioridade;
    private Boolean finalizado;

    @ManyToOne
    @JsonBackReference
    private ListaModel lista;
}
