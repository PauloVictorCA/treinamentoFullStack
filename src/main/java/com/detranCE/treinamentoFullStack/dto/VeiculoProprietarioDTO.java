package com.detranCE.treinamentoFullStack.dto;

import com.detranCE.treinamentoFullStack.entitys.Proprietario;
import com.detranCE.treinamentoFullStack.entitys.Veiculo;

public class VeiculoProprietarioDTO {

    private Veiculo veiculo;
    private Proprietario proprietario;

    public VeiculoProprietarioDTO(Veiculo veiculo, Proprietario proprietario) {
        this.veiculo = veiculo;
        this.proprietario = proprietario;
    }

    // Getters e setters

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}


