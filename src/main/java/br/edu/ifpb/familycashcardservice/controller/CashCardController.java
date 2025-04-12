package br.edu.ifpb.familycashcardservice.controller;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.service.ICashCardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private final ICashCardService cashCardService;

    public CashCardController(ICashCardService cashCardService){
        this.cashCardService = cashCardService;
    }

    @PostMapping
    public ResponseEntity<CashCardDTO> create(@RequestBody @Valid CreateCashCardDTO newCashCardDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cashCardService.save(newCashCardDTO));
    }

}
