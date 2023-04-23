package com.example.jogos.controller;

import com.example.jogos.domain.Empresa;
import com.example.jogos.repository.IEmpresaRepository;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
@CrossOrigin("http://localhost:3000")
public class EmpresaController {
    @Autowired
    private IEmpresaRepository empresas;

    @GetMapping
    public ResponseEntity<List<Empresa>> getEmpresas() {
        List<Empresa> empresasList = empresas.findAll();

        if (empresasList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(empresasList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable Integer id) {
        Optional<Empresa> empresa = empresas.findById(id);

        if (empresa.isPresent()) {
            return ResponseEntity.ok(empresa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empresa> addEmpresa(@RequestBody @Valid Empresa empresa){
        empresas.save(empresa);
        return ResponseEntity.status(201).body(empresa);
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> updateEmpresa(@RequestBody @Valid Empresa empresa, @PathVariable Integer id){
        Optional<Empresa> empresaExistente = empresas.findById(id);

        if (empresaExistente.isPresent()) {
            Empresa empresaAtualizada = empresaExistente.get();
            empresaAtualizada.setNome(empresa.getNome());
            empresaAtualizada.setEnderecoSede(empresa.getEnderecoSede());
            empresaAtualizada.setUrlImagem(empresa.getUrlImagem());

            if (empresa.listaJogos() != null) {
                empresaAtualizada.listaJogos().removeIf(jogo -> !empresa.listaJogos().contains(jogo));
                empresaAtualizada.listaJogos().addAll(empresa.listaJogos());
            }

            empresas.save(empresaAtualizada);
            return ResponseEntity.ok(empresaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmpresa(@PathVariable Integer id) {
        Optional<Empresa> empresaOptional = empresas.findById(id);

        if (empresaOptional.isPresent()) {
            empresas.delete(empresaOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
