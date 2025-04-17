package br.edu.ifpb.familycashcardservice;

import br.edu.ifpb.familycashcardservice.controller.CashCardController;
import br.edu.ifpb.familycashcardservice.dto.CashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.CreateCashCardDTO;
import br.edu.ifpb.familycashcardservice.dto.UpdateCashCardDTO;
import br.edu.ifpb.familycashcardservice.service.ICashCardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CashCardController.class)
class CashCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICashCardService cashCardService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateCashCard() throws Exception {
        CreateCashCardDTO createDTO = new CreateCashCardDTO(250.00);
        CashCardDTO responseDTO = new CashCardDTO(1L, 250.00);

        Mockito.when(cashCardService.create(any(CreateCashCardDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(post("/api/v1/cashcards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.amount").value(250.00));
    }

    @Test
    void testFindAllCashCards() throws Exception {
        CashCardDTO cashCard = new CashCardDTO(1L, 250.00);
        Page<CashCardDTO> page = new PageImpl<>(List.of(cashCard));
        Mockito.when(cashCardService.findAll(any(PageRequest.class))).thenReturn(page);

        mockMvc.perform(get("/api/v1/cashcards")
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1))
                .andExpect(jsonPath("$.content[0].amount").value(250.00));
    }

    @Test
    void testFindCashCardById() throws Exception {
        CashCardDTO cashCard = new CashCardDTO(1L, 250.00);
        Mockito.when(cashCardService.findById(1L)).thenReturn(cashCard);

        mockMvc.perform(get("/api/v1/cashcards/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.amount").value(250.00));
    }

    @Test
    void testUpdateCashCard() throws Exception {
        UpdateCashCardDTO updateDTO = new UpdateCashCardDTO(300.00);
        CashCardDTO responseDTO = new CashCardDTO(1L, 300.00);

        Mockito.when(cashCardService.update(eq(1L), any(UpdateCashCardDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(put("/api/v1/cashcards/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.amount").value(300.00));
    }

    @Test
    void testDeleteCashCard() throws Exception {
        Mockito.doNothing().when(cashCardService).delete(1L);

        mockMvc.perform(delete("/api/v1/cashcards/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}