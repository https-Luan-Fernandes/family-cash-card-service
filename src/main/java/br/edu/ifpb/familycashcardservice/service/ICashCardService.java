package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICashCardService {
    CashCardDTO findById(Long id);
    CashCardDTO create(CreateCashCardDTO createCashCardDTO);
    Page<CashCardDTO> findAll(Pageable pageable);
    CashCardDTO update(Long id, UpdateCashCardDTO updateCashCardDTO);
    void delete(Long id);
}
