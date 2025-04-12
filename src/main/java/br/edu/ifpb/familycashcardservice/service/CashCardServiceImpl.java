package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import br.edu.ifpb.familycashcardservice.entity.CashCard;
import br.edu.ifpb.familycashcardservice.mapper.CashCardMapper;
import br.edu.ifpb.familycashcardservice.repository.CashCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashCardServiceImpl implements ICashCardService {

    private final CashCardRepository cashCardRepository;

    public CashCardServiceImpl(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }


    @Override
    public CashCardDTO findById(Long requestedId) {
        return null;
    }

    @Override
    public CashCardDTO save(CreateCashCardDTO newCashCard) {
        CashCard cashCard = CashCardMapper.toCashCard(newCashCard);
        CashCard cashCardSaved = cashCardRepository.save(cashCard);
        return CashCardMapper.toCashCardDTO(cashCardSaved);
    }

    @Override
    public List<CashCardDTO> findAll() {
        return List.of();
    }

    @Override
    public CashCardDTO update(Long id, UpdateCashCardDTO updatedCashCard) {
        return null;
    }
}
