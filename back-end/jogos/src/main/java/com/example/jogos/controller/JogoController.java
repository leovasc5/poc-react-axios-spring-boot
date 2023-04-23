package com.example.jogos.controller;

import com.example.jogos.domain.Empresa;
import com.example.jogos.domain.Jogo;
import com.example.jogos.repository.IJogoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private IJogoRepository jogos;

    @GetMapping
    public ResponseEntity<List<Jogo>> getJogos() {
        List<Jogo> listaJogos = jogos.findAll();

        if (listaJogos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(listaJogos);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Jogo> getJogo(@PathVariable Integer id) {
        Optional<Jogo> jogoOptional = jogos.findById(id);

        if (jogoOptional.isPresent()) {
            return ResponseEntity.ok(jogoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Jogo> addJogo(@RequestBody @Valid Jogo jogo){
        jogos.save(jogo);
        return ResponseEntity.status(201).body(jogo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Jogo> updateJogo(@RequestBody @Valid Jogo jogo, @PathVariable Integer id){
        Optional<Jogo> jogoExistente = jogos.findById(id);

        if(jogoExistente.isPresent()){
            Jogo jogoAtualizado = jogoExistente.get();
            BeanUtils.copyProperties(jogo, jogoAtualizado, "id");
            jogos.save(jogoAtualizado);
            return ResponseEntity.ok(jogoAtualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<Jogo> updateJogoName(@PathVariable Integer id, @RequestParam @NotBlank @Min(3) @Max(63) String nome) {
        Optional<Jogo> optionalJogo = jogos.findById(id);

        if (optionalJogo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Jogo jogo = optionalJogo.get();
        jogo.setNome(nome);
        jogos.save(jogo);

        return ResponseEntity.ok(jogo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteJogo(@PathVariable Integer id) {
        if (jogos.existsById(id)) {
            jogos.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<List<Jogo>> getJogosEmpresa(@PathVariable Integer id) {
        List<Jogo> jogosOrdenados = jogos.findByEmpresaId(id);

        if (jogosOrdenados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(jogosOrdenados);
        }
    }

    @GetMapping("/maiores-faturamentos")
    public ResponseEntity<List<Jogo>> getMaioresFaturamentos() {
        List<Jogo> jogosOrdenados = jogos.findAllByOrderByFaturamentoDesc();

        if (jogosOrdenados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(jogosOrdenados);
        }
    }

    @GetMapping("/maiores-custos")
    public ResponseEntity<List<Jogo>> getMaioresCustos() {
        List<Jogo> jogosOrdenados = jogos.findAllByOrderByCustoDesc();

        if (jogosOrdenados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(jogosOrdenados);
        }
    }

    @GetMapping("/mais-baixados")
    public ResponseEntity<List<Jogo>> getMaisBaixados() {
        List<Jogo> jogosOrdenados = jogos.findAllByOrderByDownloadsDesc();

        if (jogosOrdenados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(jogosOrdenados);
        }
    }
}