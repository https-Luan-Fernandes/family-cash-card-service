package br.edu.ifpb.familycashcardservice.repository;

import br.edu.ifpb.familycashcardservice.entity.CashCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashCardRepository extends JpaRepository<CashCard, Long> { }
