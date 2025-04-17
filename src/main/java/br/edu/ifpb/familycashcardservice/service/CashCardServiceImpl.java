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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CashCardServiceImpl implements ICashCardService {

    private final ICashCardRepository cashCardRepository;

    @Override
    public CashCardDTO findById(Long id) {
        CashCard cashCard = findCashCardById(id);
        log.info("[CashCardService] Found cash card ID: {} ", cashCard.getId());
        return CashCardMapper.toCashCardDTO(cashCard);
    }

    @Override
    public CashCardDTO create(CreateCashCardDTO createCashCardDTO) {
        CashCard cashCard = CashCardMapper.toCashCard(createCashCardDTO);
        CashCard cashCardSaved = cashCardRepository.save(cashCard);
        log.info("[CashCardService] Created cash card with ID: {} and amount: {}", cashCardSaved.getId(), cashCardSaved.getAmount());
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
        log.info("[CashCardService] Updated cash card ID: {} with new amount: {}", cashCard.getId(), cashCard.getAmount());
        return CashCardMapper.toCashCardDTO(cashCard);
    }

    @Override
    public void delete(Long id) {
        CashCard cashCard = findCashCardById(id);
        cashCardRepository.delete(cashCard);
        log.info("[CashCardService] Deleted cash card ID: {} ", cashCard.getId());
    }

    private CashCard findCashCardById(Long id) {
        return cashCardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(ExceptionMessage.CASHCARD_NOT_FOUND.getMessage()));
    }
}
