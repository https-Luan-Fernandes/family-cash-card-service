package br.edu.ifpb.familycashcardservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateCashCardDTO(@NotNull @Positive Double amount) {
}