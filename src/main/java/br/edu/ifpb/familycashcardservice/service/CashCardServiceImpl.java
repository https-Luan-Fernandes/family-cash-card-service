package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import br.edu.ifpb.familycashcardservice.entity.CashCard;
import br.edu.ifpb.familycashcardservice.mapper.CashCardMapper;
import br.edu.ifpb.familycashcardservice.repository.CashCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CashCardServiceImpl implements ICashCardService {

    private final CashCardRepository cashCardRepository;

    public CashCardServiceImpl(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }


    @Override
    public CashCardDTO findById(Long requestedId) {
        CashCard cashCard = cashCardRepository.findById(requestedId).orElse(null);
        return CashCardMapper.toCashCardDTO(cashCard);
    }

    @Override
    public CashCardDTO save(CreateCashCardDTO newCashCard) {
        CashCard cashCard = CashCardMapper.toCashCard(newCashCard);
        CashCard cashCardSaved = cashCardRepository.save(cashCard);
        return CashCardMapper.toCashCardDTO(cashCardSaved);
    }

    @Override
    public List<CashCardDTO> findAll() {
        return cashCardRepository.findAll()
                .stream()
                .map(CashCardMapper::toCashCardDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CashCardDTO update(Long id, UpdateCashCardDTO updatedCashCard) {
        CashCard cashCard = cashCardRepository.findById(id).orElse(null);
        cashCard.setAmount(updatedCashCard.amount());
        cashCardRepository.save(cashCard);
        return CashCardMapper.toCashCardDTO(cashCard);
    }

    @Override
    public void delete(Long id) {
        cashCardRepository.deleteById(id);
    }
}
