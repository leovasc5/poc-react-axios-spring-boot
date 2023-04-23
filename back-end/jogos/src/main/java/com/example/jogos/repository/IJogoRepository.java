package com.example.jogos.repository;

import com.example.jogos.domain.Empresa;
import com.example.jogos.domain.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IJogoRepository extends JpaRepository<Jogo, Integer> {
    List<Jogo> findAllByOrderByFaturamentoDesc();
    List<Jogo> findByEmpresaId(Integer id);
    List<Jogo> findAllByOrderByCustoDesc();
    List<Jogo> findAllByOrderByDownloadsDesc();

}
