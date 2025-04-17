package br.edu.ifpb.familycashcardservice.controller;

import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import br.edu.ifpb.familycashcardservice.service.ICashCardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cashcards")
@RequiredArgsConstructor
@Slf4j
public class CashCardController {

    private final ICashCardService cashCardService;

    @PostMapping
    public ResponseEntity<CashCardDTO> create(@RequestBody @Valid CreateCashCardDTO createCashCardDTO){
        log.info("POST api/v1/cashcards - Creating cash card: {}", createCashCardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cashCardService.create(createCashCardDTO));
    }

    @GetMapping
    public ResponseEntity<Page<CashCardDTO>> findAll(Pageable pageable){
        log.info("GET api/v1/cashcards - Finding all cash cards, page: {} with size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(cashCardService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CashCardDTO> findById(@PathVariable Long id){
        log.info("GET api/v1/cashcards/{} - Searching for cash card with ID: {}", id, id);
        return ResponseEntity.ok(cashCardService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CashCardDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateCashCardDTO updateCashCardDTO){
        log.info("PUT api/v1/cashcards/{} - Updating cash card with ID: {} to new value: {}", id, id, updateCashCardDTO);
        return ResponseEntity.ok(cashCardService.update(id, updateCashCardDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        log.info("DELETE api/v1/cashcards/{} - Deleting cash card with ID: {}", id, id);
        cashCardService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
