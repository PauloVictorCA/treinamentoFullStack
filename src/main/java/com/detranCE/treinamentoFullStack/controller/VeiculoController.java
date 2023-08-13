package com.detranCE.treinamentoFullStack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.detranCE.treinamentoFullStack.dto.VeiculoProprietarioDTO;
import com.detranCE.treinamentoFullStack.entitys.Veiculo;
import com.detranCE.treinamentoFullStack.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoProprietarioDTO> getVeiculoByPlaca(@PathVariable String placa) {
        VeiculoProprietarioDTO veiculoProprietarioDTO = veiculoService.getVeiculoByPlaca(placa);
        if (veiculoProprietarioDTO != null) {
            return ResponseEntity.ok(veiculoProprietarioDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VeiculoProprietarioDTO> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        try {
            VeiculoProprietarioDTO novoVeiculoProprietarioDTO = veiculoService.cadastrarVeiculo(veiculo);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculoProprietarioDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable String placa) {
        boolean removido = veiculoService.deletarVeiculo(placa);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{placa}")
    public ResponseEntity<VeiculoProprietarioDTO> atualizarVeiculo(
            @PathVariable String placa, @RequestBody Veiculo veiculo) {
        try {
            VeiculoProprietarioDTO veiculoProprietarioDTO = veiculoService.atualizarVeiculo(placa, veiculo);
            if (veiculoProprietarioDTO != null) {
                return ResponseEntity.ok(veiculoProprietarioDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}





