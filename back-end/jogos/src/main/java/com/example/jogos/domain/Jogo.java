package com.example.jogos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nome;

    @PastOrPresent
    private LocalDateTime dataLancamento;

    @PositiveOrZero
    private Long custo;

    @PositiveOrZero
    private Long faturamento;

    @PositiveOrZero
    private int downloads;

    @NotBlank
    private String urlImagem;

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCusto() {
        return custo;
    }

    public void setCusto(Long custo) {
        this.custo = custo;
    }

    public Long getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Long faturamento) {
        this.faturamento = faturamento;
    }

    public Empresa listaEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Integer getIdEmpresa(){
        return empresa.getId();
    }

    public String getNomeEmpresa(){
        return empresa.getNome();
    }

    public String getUrlImagemEmpresa(){
        return empresa.getUrlImagem();
    }
}
