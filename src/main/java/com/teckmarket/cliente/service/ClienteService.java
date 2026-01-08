package com.teckmarket.cliente.service;

import com.teckmarket.cliente.dto.ClienteDTO;
import com.teckmarket.cliente.model.Cliente;
import com.teckmarket.cliente.repository.ClienteRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criarCliente(ClienteDTO clienteDTO) {
        validarCpfExistente(clienteDTO.getCpf());

        Cliente cliente = new Cliente();
        copiarDadosDtoParaEntidade(clienteDTO, cliente);

        return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public List<Cliente> buscarPorNome(String parteDoNome) {
        return repository.findByNomeContainingIgnoreCase(parteDoNome);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Cliente> atualizarCliente(Long id, ClienteDTO clienteDTO) {
        return repository.findById(id).map(cliente -> {
            if (!cliente.getCpf().equals(clienteDTO.getCpf())) {
                validarCpfExistente(clienteDTO.getCpf());
            }
            copiarDadosDtoParaEntidade(clienteDTO, cliente);
            return repository.save(cliente);
        });
    }

    public boolean deletarCliente(Long id) {
        return repository.findById(id).map(cliente -> {
            repository.delete(cliente);
            return true;
        }).orElse(false);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com o ID" + id);
        }
        repository.deleteById(id);
    }

    private  void copiarDadosDtoParaEntidade(ClienteDTO dto, Cliente entidade) {
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setCpf(dto.getCpf());
    }

    private void validarCpfExistente(String cpf) {
        repository.findByCpf(cpf).ifPresent(c -> {
            throw new DataIntegrityViolationException("CPF já cadastrado");
        });
    }

}
