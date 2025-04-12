package br.edu.ifpb.familycashcardservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cash_card")
public class CashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    protected CashCard() {}  // Construtor sem argumentos para JPA

    public CashCard(Double amount) {
        this.amount = amount;
    }

    public Long getId() { return id; }
    public Double getAmount() { return amount; }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}