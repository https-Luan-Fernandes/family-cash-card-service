package br.edu.ifpb.familycashcardservice.repository;

import br.edu.ifpb.familycashcardservice.model.CashCard;
import org.springframework.data.repository.CrudRepository;

public interface CashCardRepository extends CrudRepository<CashCard, Long> {}
