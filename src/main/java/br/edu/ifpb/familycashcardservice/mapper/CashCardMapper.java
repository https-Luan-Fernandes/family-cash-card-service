package br.edu.ifpb.familycashcardservice.mapper;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.entity.CashCard;

public final class CashCardMapper {

    private CashCardMapper() {}

    public static CashCardDTO toCashCardDTO(CashCard cashCard) {
        return new CashCardDTO(cashCard.getId(), cashCard.getAmount());
    }

    public static CashCard toCashCard(CreateCashCardDTO createCashCardDTO) {
        return new CashCard(createCashCardDTO.amount());
    }

}
