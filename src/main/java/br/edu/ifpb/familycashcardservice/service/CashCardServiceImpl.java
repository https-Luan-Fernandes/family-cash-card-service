package br.edu.ifpb.familycashcardservice.service;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import br.edu.ifpb.familycashcardservice.entity.CashCard;
import br.edu.ifpb.familycashcardservice.enums.ExceptionMessage;
import br.edu.ifpb.familycashcardservice.exception.ResourceNotFoundException;
import br.edu.ifpb.familycashcardservice.mapper.CashCardMapper;
import br.edu.ifpb.familycashcardservice.repository.ICashCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CashCardServiceImpl implements ICashCardService {

    private final ICashCardRepository cashCardRepository;

    @Override
    public CashCardDTO findById(Long id) {
        CashCard cashCard = findCashCardById(id);
        return CashCardMapper.toCashCardDTO(cashCard);
    }

    @Override
    public CashCardDTO create(CreateCashCardDTO createCashCardDTO) {
        CashCard cashCard = CashCardMapper.toCashCard(createCashCardDTO);
        CashCard cashCardSaved = cashCardRepository.save(cashCard);
        return CashCardMapper.toCashCardDTO(cashCardSaved);
    }

    @Override
    public Page<CashCardDTO> findAll(Pageable pageable) {
        return cashCardRepository.findAll(pageable)
                .map(CashCardMapper::toCashCardDTO);
    }

    @Override
    public CashCardDTO update(Long id, UpdateCashCardDTO updateCashCardDTO) {
        CashCard cashCard = findCashCardById(id);
        cashCard.setAmount(updateCashCardDTO.amount());
        cashCardRepository.save(cashCard);
        return CashCardMapper.toCashCardDTO(cashCard);
    }

    @Override
    public void delete(Long id) {
        CashCard cashCard = findCashCardById(id);
        cashCardRepository.delete(cashCard);
    }

    private CashCard findCashCardById(Long id) {
        return cashCardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.CASHCARD_NOT_FOUND.getMessage()));
    }
}
