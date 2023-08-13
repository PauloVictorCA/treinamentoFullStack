package com.detranCE.treinamentoFullStack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.detranCE.treinamentoFullStack.entitys.Veiculo;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Veiculo findByPlaca(String placa);

    @Query("SELECT v FROM Veiculo v WHERE v.cpfCnpjProprietario = :cpfCnpj")
    List<Veiculo> findByCpfCnpjProprietario(String cpfCnpj);

    // Adicionar o método para verificar se uma placa já está cadastrada
    boolean existsByPlaca(String placa);
    
    void deleteByPlaca(String placa);
}


