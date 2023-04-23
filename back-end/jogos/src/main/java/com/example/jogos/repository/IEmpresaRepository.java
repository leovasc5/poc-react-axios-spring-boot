package com.example.jogos.repository;

import com.example.jogos.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
}
