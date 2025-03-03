package br.edu.ifpb.familycashcardservice.dto;

import org.springframework.data.annotation.Id;

public record CashCardDTO(@Id Long id, Double amount) { }
