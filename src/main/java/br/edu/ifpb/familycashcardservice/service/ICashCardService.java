package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICashCardService {
    CashCardDTO findById(Long requestedId);
    CashCardDTO save(CreateCashCardDTO newCashCard);
    List<CashCardDTO> findAll();
    CashCardDTO update(Long id, UpdateCashCardDTO updatedCashCard);
    void delete(Long id);
}
