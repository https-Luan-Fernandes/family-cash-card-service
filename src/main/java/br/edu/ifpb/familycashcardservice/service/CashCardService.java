package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.model.CashCard;
import br.edu.ifpb.familycashcardservice.repository.CashCardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    @Override
    public CashCardDTO save(CashCardDTO newCashCard) {
        CashCard cashCard = new CashCard(null, newCashCard.amount()); // ID será gerado automaticamente
        CashCard savedCashCard = cashCardRepository.save(cashCard);
        return new CashCardDTO(savedCashCard.getId(), savedCashCard.getAmount());
    }


}
