package com.solbs.unoapi.dtos;

import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.entities.enums.StatusAmostra;

import java.time.Instant;
import java.time.LocalDate;

public class AmostraDTO {
    private Long solicitacaoDeAnalise;
    private int statusAmostra;
    private Instant dataDeEntrada;
    private String tipo;
    private String notaFiscal;
    private LocalDate validade;

    public Long getSolicitacaoDeAnalise() {
        return solicitacaoDeAnalise;
    }

    public void setSolicitacaoDeAnalise(Long solicitacaoDeAnalise) {
        this.solicitacaoDeAnalise = solicitacaoDeAnalise;
    }

    public int getStatusAmostra() {
        return statusAmostra;
    }

    public void setStatusAmostra(int statusAmostra) {
        this.statusAmostra = statusAmostra;
    }

    public Instant getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(Instant dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
