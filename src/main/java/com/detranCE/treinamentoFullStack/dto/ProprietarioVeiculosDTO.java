package com.detranCE.treinamentoFullStack.dto;

import java.util.List;

import com.detranCE.treinamentoFullStack.entitys.Proprietario;
import com.detranCE.treinamentoFullStack.entitys.Veiculo;

public class ProprietarioVeiculosDTO {
    private Proprietario proprietario;
    private List<Veiculo> veiculos;

    public ProprietarioVeiculosDTO(Proprietario proprietario, List<Veiculo> veiculos) {
        this.proprietario = proprietario;
        this.veiculos = veiculos;
    }

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

    
}
