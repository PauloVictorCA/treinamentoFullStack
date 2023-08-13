package com.detranCE.treinamentoFullStack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; 

import com.detranCE.treinamentoFullStack.dto.ProprietarioVeiculosDTO;
import com.detranCE.treinamentoFullStack.entitys.Proprietario;
import com.detranCE.treinamentoFullStack.entitys.Veiculo;
import com.detranCE.treinamentoFullStack.repository.ProprietarioRepository;
import com.detranCE.treinamentoFullStack.repository.VeiculoRepository;

@Service
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public ProprietarioVeiculosDTO getProprietarioWithVeiculos(String cpfCnpj) {
        Proprietario proprietario = proprietarioRepository.findByCpfCnpj(cpfCnpj);
        if (proprietario != null) {
            List<Veiculo> veiculos = veiculoRepository.findByCpfCnpjProprietario(cpfCnpj);
            return new ProprietarioVeiculosDTO(proprietario, veiculos);
        }
        return null;
    }
    
    public Proprietario cadastrarProprietario(Proprietario proprietario) {
        if (proprietarioRepository.existsByCpfCnpj(proprietario.getCpfCnpj())) {
            throw new IllegalArgumentException("CPF/CNPJ já cadastrado");
        }
        return proprietarioRepository.save(proprietario);
    }

    public boolean deletarProprietario(String cpfCnpj) {
        Proprietario proprietario = proprietarioRepository.findByCpfCnpj(cpfCnpj);
        if (proprietario != null) {
            proprietarioRepository.delete(proprietario);
            return true;
        }
        return false;
    }

    public Proprietario atualizarProprietario(String cpfCnpj, Proprietario proprietario) {
        Proprietario proprietarioExistente = proprietarioRepository.findByCpfCnpj(cpfCnpj);
        if (proprietarioExistente != null) {
            proprietarioExistente.setNome(proprietario.getNome());
            proprietarioExistente.setEndereco(proprietario.getEndereco());
            // Atualize outros campos conforme necessário

            Proprietario proprietarioAtualizado = proprietarioRepository.save(proprietarioExistente);
            return proprietarioAtualizado;
        }
        return null;
    }
}



