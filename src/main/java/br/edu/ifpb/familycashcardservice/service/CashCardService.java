package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.model.CashCard;
import br.edu.ifpb.familycashcardservice.repository.CashCardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashCardService implements ICashCardService {
    private final CashCardRepository cashCardRepository;

    public CashCardService(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    public ResponseEntity<CashCardDTO> findById(Long requestedId) {
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
        return cashCardOptional
                .map(cashCard -> ResponseEntity.ok(new CashCardDTO(cashCard.getId(), cashCard.getAmount())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public CashCardDTO save(CashCardDTO newCashCard) {
        CashCard cashCard = new CashCard(null, newCashCard.amount());
        CashCard savedCashCard = cashCardRepository.save(cashCard);
        return new CashCardDTO(savedCashCard.getId(), savedCashCard.getAmount());
    }

    public ResponseEntity<List<CashCardDTO>> findAll(Pageable pageable) {
        Page<CashCard> page = cashCardRepository.findAll(pageable);
        List<CashCardDTO> cashCardDTOs = page.getContent()
                .stream()
                .map(cashCard -> new CashCardDTO(cashCard.getId(), cashCard.getAmount()))
                .toList();
        return ResponseEntity.ok(cashCardDTOs);
    }

    public ResponseEntity<CashCardDTO> update(Long id, CashCardDTO updatedCashCard) {
        Optional<CashCard> existingCashCard = cashCardRepository.findById(id);

        if (existingCashCard.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CashCard cashCard = existingCashCard.get();
        cashCard.setAmount(updatedCashCard.amount());

        CashCard savedCashCard = cashCardRepository.save(cashCard);
        return ResponseEntity.ok(new CashCardDTO(savedCashCard.getId(), savedCashCard.getAmount()));
    }



}
