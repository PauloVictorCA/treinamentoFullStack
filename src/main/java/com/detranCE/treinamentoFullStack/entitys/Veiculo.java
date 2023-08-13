package com.detranCE.treinamentoFullStack.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "proprietario_veiculo", name = "veiculo")
public class Veiculo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String renavam;
    private String cpfCnpjProprietario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getCpfCnpjProprietario() {
		return cpfCnpjProprietario;
	}

	public void setCpfCnpjProprietario(String cpfCnpjProprietario) {
		this.cpfCnpjProprietario = cpfCnpjProprietario;
	}

}
