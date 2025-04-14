package br.edu.ifpb.familycashcardservice.repository;

import br.edu.ifpb.familycashcardservice.entity.CashCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICashCardRepository extends JpaRepository<CashCard, Long> { }
