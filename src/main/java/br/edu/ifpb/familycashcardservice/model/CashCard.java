package br.edu.ifpb.familycashcardservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;

    protected CashCard() {}  // Construtor sem argumentos para JPA

    public CashCard(Long id, Double amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public Double getAmount() { return amount; }
}