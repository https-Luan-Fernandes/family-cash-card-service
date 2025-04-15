package br.edu.ifpb.familycashcardservice.controller;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import br.edu.ifpb.familycashcardservice.service.ICashCardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cashcards")
public class CashCardController {

    private final ICashCardService cashCardService;

    public CashCardController(ICashCardService cashCardService){
        this.cashCardService = cashCardService;
    }

    @PostMapping
    public ResponseEntity<CashCardDTO> save(@RequestBody @Valid CreateCashCardDTO newCashCardDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cashCardService.save(newCashCardDTO));
    }

    @GetMapping
    public ResponseEntity<List<CashCardDTO>> findAll(){
        return ResponseEntity.ok(cashCardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CashCardDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(cashCardService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CashCardDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateCashCardDTO updateCashCardDTO){
        return ResponseEntity.ok(cashCardService.update(id, updateCashCardDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cashCardService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
