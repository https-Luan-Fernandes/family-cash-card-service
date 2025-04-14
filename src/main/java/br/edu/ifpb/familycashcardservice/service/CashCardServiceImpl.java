package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import br.edu.ifpb.familycashcardservice.entity.CashCard;
import br.edu.ifpb.familycashcardservice.exception.ResourceNotFoundException;
import br.edu.ifpb.familycashcardservice.mapper.CashCardMapper;
import br.edu.ifpb.familycashcardservice.repository.ICashCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CashCardServiceImpl implements ICashCardService {

    private final ICashCardRepository cashCardRepository;

    public CashCardServiceImpl(ICashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }


    @Override
    public CashCardDTO findById(Long requestedId) {
        CashCard cashCard = cashCardRepository.findById(requestedId).orElseThrow(
                () -> new ResourceNotFoundException("Cash card not found"));
        return CashCardMapper.toCashCardDTO(cashCard);
    }

    @Override
    public CashCardDTO save(CreateCashCardDTO newCashCard) {
        if(newCashCard.amount() < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
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
        CashCard cashCard = cashCardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cash card not found")
        );
        cashCard.setAmount(updatedCashCard.amount());
        cashCardRepository.save(cashCard);
        return CashCardMapper.toCashCardDTO(cashCard);
    }

    @Override
    public void delete(Long id) {
        CashCard cashCard = cashCardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cash card not found")
        );
        cashCardRepository.deleteById(cashCard.getId());
    }
}
