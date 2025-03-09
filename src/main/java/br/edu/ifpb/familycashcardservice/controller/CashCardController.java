package br.edu.ifpb.familycashcardservice.controller;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.model.CashCard;
import br.edu.ifpb.familycashcardservice.service.ICashCardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Scanner;


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
    public ResponseEntity<Void> createCashCard(@RequestBody CashCardDTO newCashCardRequest, UriComponentsBuilder ucb) {
        CashCardDTO savedCashCard = cashCardService.save(newCashCardRequest);
        URI locationOfNewCashCard = ucb
                .path("/cashcards/{id}")
                .buildAndExpand(savedCashCard.id())
                .toUri();
        return ResponseEntity.created(locationOfNewCashCard).build();
    }

    @GetMapping
    public ResponseEntity<List<CashCardDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return cashCardService.findAll(pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CashCardDTO> updateCashCard(
            @PathVariable Long id,
            @RequestBody CashCardDTO updatedCashCard) {
        return cashCardService.update(id, updatedCashCard);
    }


}
