package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import org.springframework.http.ResponseEntity;

public interface ICashCardService {
    ResponseEntity<CashCardDTO> findById(Long requestedId);
}
