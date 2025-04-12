package br.edu.ifpb.familycashcardservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateCashCardDTO(@NotNull @Positive Double amount) { }
