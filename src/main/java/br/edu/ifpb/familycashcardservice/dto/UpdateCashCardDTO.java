package br.edu.ifpb.familycashcardservice.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateCashCardDTO(@NotNull Double amount) { }