package br.edu.ifpb.familycashcardservice.controller;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import br.edu.ifpb.familycashcardservice.service.ICashCardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cashcards")
@RequiredArgsConstructor
public class CashCardController {

    private final ICashCardService cashCardService;

    @PostMapping
    public ResponseEntity<CashCardDTO> create(@RequestBody @Valid CreateCashCardDTO createCashCardDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cashCardService.create(createCashCardDTO));
    }

    @GetMapping
    public ResponseEntity<Page<CashCardDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(cashCardService.findAll(pageable));
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
