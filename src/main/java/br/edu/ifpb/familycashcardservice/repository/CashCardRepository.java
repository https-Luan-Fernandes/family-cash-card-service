package br.edu.ifpb.familycashcardservice.repository;

import br.edu.ifpb.familycashcardservice.model.CashCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CashCardRepository extends PagingAndSortingRepository<CashCard, Long> {
    Optional<CashCard> findById(Long requestedId);

    CashCard save(CashCard cashCard);
}
