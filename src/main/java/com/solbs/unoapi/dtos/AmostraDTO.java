package com.solbs.unoapi.dtos;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class AmostraDTO {
    private String solicitacaoDeAnalise;
    private int statusAmostra;
    private String nomeAmostra;
    private Instant dataDeEntrada;
    private String tipo;
    private String notaFiscal;
    private LocalDate validade;

    public String getSolicitacaoDeAnalise() {
        return solicitacaoDeAnalise;
    }

    public void setSolicitacaoDeAnalise(String solicitacaoDeAnalise) {
        this.solicitacaoDeAnalise = solicitacaoDeAnalise;
    }

    public int getStatusAmostra() {
        return statusAmostra;
    }

    public void setStatusAmostra(int statusAmostra) {
        this.statusAmostra = statusAmostra;
    }

    public String getNomeAmostra() {
        return nomeAmostra;
    }

    public void setNomeAmostra(String nomeAmostra) {
        this.nomeAmostra = nomeAmostra;
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
