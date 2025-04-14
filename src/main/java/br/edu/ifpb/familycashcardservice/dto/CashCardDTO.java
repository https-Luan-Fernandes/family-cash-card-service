package br.edu.ifpb.familycashcardservice.dto;

import jakarta.validation.constraints.NotNull;

public record CashCardDTO(@NotNull Long id,@NotNull Double amount) { }
