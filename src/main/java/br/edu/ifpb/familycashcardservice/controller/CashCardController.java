package br.edu.ifpb.familycashcardservice.controller;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.model.CashCard;
import br.edu.ifpb.familycashcardservice.service.ICashCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private final ICashCardService cashCardService;

    public CashCardController(ICashCardService cashCardService){
        this.cashCardService = cashCardService;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCardDTO> findById(@PathVariable Long requestedId) {
        return cashCardService.findById(requestedId);
    }

    @PostMapping
    private ResponseEntity<Void> createCashCard(@RequestBody CashCard newCashCardRequest, UriComponentsBuilder ucb) {
        CashCard savedCashCard = cashCardRepository.save(newCashCardRequest);
        URI locationOfNewCashCard = ucb
                .path("cashcards/{id}")
                .buildAndExpand(savedCashCard.id())
                .toUri();
        return ResponseEntity.created(locationOfNewCashCard).build();
    }

}
