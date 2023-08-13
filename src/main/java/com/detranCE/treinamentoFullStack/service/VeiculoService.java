package com.detranCE.treinamentoFullStack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.detranCE.treinamentoFullStack.dto.VeiculoProprietarioDTO;
import com.detranCE.treinamentoFullStack.entitys.Proprietario;
import com.detranCE.treinamentoFullStack.entitys.Veiculo;
import com.detranCE.treinamentoFullStack.repository.ProprietarioRepository;
import com.detranCE.treinamentoFullStack.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    public VeiculoProprietarioDTO getVeiculoByPlaca(String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa);
        if (veiculo != null) {
            Proprietario proprietario = proprietarioRepository.findByCpfCnpj(veiculo.getCpfCnpjProprietario());
            return new VeiculoProprietarioDTO(veiculo, proprietario);
        }
        return null;
    }
    
    public VeiculoProprietarioDTO cadastrarVeiculo(Veiculo veiculo) {
        if (veiculoRepository.existsByPlaca(veiculo.getPlaca())) {
            throw new IllegalArgumentException("Placa já cadastrada");
        }

        Veiculo novoVeiculo = veiculoRepository.save(veiculo);

        Proprietario proprietario = proprietarioRepository.findByCpfCnpj(veiculo.getCpfCnpjProprietario());

        return new VeiculoProprietarioDTO(novoVeiculo, proprietario);
    }
    
    public boolean deletarVeiculo(String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa);
        if (veiculo != null) {
            veiculoRepository.delete(veiculo);
            return true;
        }
        return false;
    }

    public VeiculoProprietarioDTO atualizarVeiculo(String placa, Veiculo veiculo) {
        Veiculo veiculoExistente = veiculoRepository.findByPlaca(placa);
        if (veiculoExistente != null) {
            veiculoExistente.setRenavam(veiculo.getRenavam());
            veiculoExistente.setCpfCnpjProprietario(veiculo.getCpfCnpjProprietario());
            Veiculo veiculoAtualizado = veiculoRepository.save(veiculoExistente);

            Proprietario proprietario = proprietarioRepository.findByCpfCnpj(veiculoAtualizado.getCpfCnpjProprietario());
            return new VeiculoProprietarioDTO(veiculoAtualizado, proprietario);
        }
        return null;
    }

    // Outros métodos do serviço
}





