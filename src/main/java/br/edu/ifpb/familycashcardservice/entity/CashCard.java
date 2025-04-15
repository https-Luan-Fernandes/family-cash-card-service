package br.edu.ifpb.familycashcardservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cash_card")
@Getter
@NoArgsConstructor
public class CashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private Double amount;

    public CashCard(Double amount) {
        this.amount = amount;
    }
}