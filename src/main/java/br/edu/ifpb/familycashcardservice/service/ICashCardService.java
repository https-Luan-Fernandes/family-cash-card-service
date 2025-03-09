package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.model.CashCard;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICashCardService {
    ResponseEntity<CashCardDTO> findById(Long requestedId);
    CashCardDTO save(CashCardDTO newCashCard);
    ResponseEntity<List<CashCardDTO>> findAll(Pageable pageable);

    ResponseEntity<CashCardDTO> update(Long id, CashCardDTO updatedCashCard);
}
