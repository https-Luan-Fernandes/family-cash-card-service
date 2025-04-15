package br.edu.ifpb.familycashcardservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record UpdateCashCardDTO(@NotNull @PositiveOrZero(message = "Amount must be zero or positive") Double amount) { }