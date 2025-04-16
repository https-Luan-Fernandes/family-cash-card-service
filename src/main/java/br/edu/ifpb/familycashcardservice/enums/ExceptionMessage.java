package br.edu.ifpb.familycashcardservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    CASHCARD_NOT_FOUND("Cash card not found"),
    INVALID_AMOUNT("Amount cannot be negative");

    private final String message;

}
