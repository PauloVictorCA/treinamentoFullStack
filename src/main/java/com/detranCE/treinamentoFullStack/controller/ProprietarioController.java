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

import com.detranCE.treinamentoFullStack.dto.ProprietarioVeiculosDTO;
import com.detranCE.treinamentoFullStack.entitys.Proprietario;
import com.detranCE.treinamentoFullStack.service.ProprietarioService;


@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioService proprietarioService;

    @GetMapping("/{cpfCnpj}")
    public ProprietarioVeiculosDTO getProprietarioWithVeiculos(@PathVariable String cpfCnpj) {
        return proprietarioService.getProprietarioWithVeiculos(cpfCnpj);
    }
    
    @PostMapping
    public ResponseEntity<Proprietario> cadastrarProprietario(@RequestBody Proprietario proprietario) {
        try {
            Proprietario novoProprietario = proprietarioService.cadastrarProprietario(proprietario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProprietario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{cpfCnpj}")
    public ResponseEntity<Void> deletarProprietario(@PathVariable String cpfCnpj) {
        boolean removido = proprietarioService.deletarProprietario(cpfCnpj);
        if (removido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{cpfCnpj}")
    public ResponseEntity<Proprietario> atualizarProprietario(
            @PathVariable String cpfCnpj, @RequestBody Proprietario proprietario) {
        try {
            Proprietario proprietarioAtualizado = proprietarioService.atualizarProprietario(cpfCnpj, proprietario);
            if (proprietarioAtualizado != null) {
                return ResponseEntity.ok(proprietarioAtualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

