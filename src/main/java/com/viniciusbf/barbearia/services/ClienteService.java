package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.dtos.ClienteRequestDTO;
import com.viniciusbf.barbearia.dtos.ClienteUpdateDTO;
import com.viniciusbf.barbearia.entities.Cliente;
import com.viniciusbf.barbearia.exceptions.ClientInUseException;
import com.viniciusbf.barbearia.exceptions.ResourceNotFoundException;
import com.viniciusbf.barbearia.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public Cliente getById(Integer id){
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente " + id + " não encontrado."));
    }

    public Cliente create(ClienteRequestDTO clienteRequestDTO){
        Cliente cliente = new Cliente(null, clienteRequestDTO.getNome(), clienteRequestDTO.getTelefone(), clienteRequestDTO.getEmail());
        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente update(Integer id, ClienteUpdateDTO clienteUpdateDTO){
        Cliente cliente = getById(id);

        if (clienteUpdateDTO.getEmail() != null){
            cliente.setEmail(clienteUpdateDTO.getEmail());
        }

        if (clienteUpdateDTO.getTelefone() != null){
            cliente.setTelefone(clienteUpdateDTO.getTelefone());
        }

        clienteRepository.save(cliente);
        return cliente;
    }

    public void delete(Integer id){
        if (clienteRepository.existsById(id)){
            if (!clienteRepository.existeAgendamentoComCliente(id)){
                clienteRepository.deleteById(id);
            } else {
                throw new ClientInUseException("O cliente " + id + " está em um agendamento e não pode ser excluido.");
            }
        } else {
            throw new ResourceNotFoundException("Cliente " + id + " não encontrado.");
        }

    }
}
