package com.teckmarket.cliente.clienteService;

import com.teckmarket.cliente.dto.ClienteDTO;
import com.teckmarket.cliente.model.Cliente;
import com.teckmarket.cliente.repository.ClienteRepository;
import com.teckmarket.cliente.service.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test
    @DisplayName("Deve criar um cliente com sucesso")
    void criarClienteSucesso() {
        // Cenário
        ClienteDTO dto = new ClienteDTO();
        dto.setNome("Danilo");
        dto.setEmail("danilo@teste.com");
        dto.setCpf("12345678901");

        when(repository.findByCpf(dto.getCpf())).thenReturn(Optional.empty());
        when(repository.save(any(Cliente.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Ação
        Cliente resultado = service.criarCliente(dto);

        // Validação
        assertNotNull(resultado);
        assertEquals("Danilo", resultado.getNome());
        verify(repository, times(1)).save(any(Cliente.class));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar cadastrar CPF duplicado")
    void criarClienteErroCpfDuplicado() {
        // Cenário
        ClienteDTO dto = new ClienteDTO();
        dto.setCpf("12345678901");

        when(repository.findByCpf(dto.getCpf())).thenReturn(Optional.of(new Cliente()));

        // Ação & Validação
        assertThrows(DataIntegrityViolationException.class, () -> {
            service.criarCliente(dto);
        });

        verify(repository, never()).save(any(Cliente.class));
    }
}