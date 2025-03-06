package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.model.CashCard;
import org.springframework.http.ResponseEntity;

public interface ICashCardService {
    ResponseEntity<CashCardDTO> findById(Long requestedId);
    CashCardDTO save(CashCardDTO newCashCard);
}
