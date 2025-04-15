package br.edu.ifpb.familycashcardservice.enums;

public enum ExceptionMessage {
    CASHCARD_NOT_FOUND("Cash card not found"),
    INVALID_AMOUNT("Amount cannot be negative");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
