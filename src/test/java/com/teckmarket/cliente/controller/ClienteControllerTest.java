package com.teckmarket.cliente.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teckmarket.cliente.dto.ClienteDTO;
import com.teckmarket.cliente.model.Cliente;
import com.teckmarket.cliente.service.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // Atenção a esta importação
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class) // Carrega apenas a camada Web
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc; // Simula o navegador/Postman

    @Autowired
    private ObjectMapper objectMapper; // Transforma Objeto em JSON

    @MockBean // Cria um Mock do Service para o Controller não depender do banco real
    private ClienteService service;

    @Test
    @DisplayName("Deve retornar status 201 Created ao criar cliente válido")
    void criarClienteSucesso() throws Exception {
        // Cenário: O que enviamos
        ClienteDTO dto = new ClienteDTO();
        dto.setNome("Maria Silva");
        dto.setEmail("maria@email.com");
        dto.setCpf("12345678901");

        // Cenário: O que o Service devolve (simulado)
        Cliente clienteSalvo = new Cliente(1L, "Maria Silva", "maria@email.com", "12345678901");
        when(service.criarCliente(any(ClienteDTO.class))).thenReturn(clienteSalvo);

        // Ação: Disparar a requisição POST
        mockMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))) // Converte DTO para JSON string

                // Validação: O que esperamos de volta
                .andExpect(status().isCreated()) // Espera status 201
                .andExpect(jsonPath("$.id").value(1L)) // Espera ID 1 no JSON de resposta
                .andExpect(jsonPath("$.nome").value("Maria Silva")); // Espera nome correto
    }
}