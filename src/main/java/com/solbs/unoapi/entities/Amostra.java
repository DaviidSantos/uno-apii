package com.solbs.unoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solbs.unoapi.entities.enums.StatusAmostra;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_amostra")
public class Amostra {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmostra;
    
    private String nomeAmostra;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_solicitacao_de_analise")
    private SolicitacaoDeAnalise solicitacaoDeAnalise;
    private StatusAmostra statusAmostra;
    private Instant dataDeEntrada;
    private String tipo;
    private String notaFiscal;
    private LocalDate validade;

    @OneToMany(mappedBy = "amostra")
    private Set<Ensaio> ensaios = new HashSet<>();

    public Amostra() {
    }

    public Amostra(Long idAmostra, String nomeAmostra, SolicitacaoDeAnalise solicitacaoDeAnalise, StatusAmostra statusAmostra, Instant dataDeEntrada, String tipo, String notaFiscal, LocalDate validade) {
        this.idAmostra = idAmostra;
        this.nomeAmostra = nomeAmostra;
        this.solicitacaoDeAnalise = solicitacaoDeAnalise;
        this.statusAmostra = statusAmostra;
        this.dataDeEntrada = dataDeEntrada;
        this.tipo = tipo;
        this.notaFiscal = notaFiscal;
        this.validade = validade;
    }

    public Long getIdAmostra() {
        return idAmostra;
    }

    public void setIdAmostra(Long idAmostra) {
        this.idAmostra = idAmostra;
    }

    public String getNomeAmostra() {
        return nomeAmostra;
    }

    public void setNomeAmostra(String nomeAmostra) {
        this.nomeAmostra = nomeAmostra;
    }

    public SolicitacaoDeAnalise getSolicitacaoDeAnalise() {
        return solicitacaoDeAnalise;
    }

    public void setSolicitacaoDeAnalise(SolicitacaoDeAnalise solicitacaoDeAnalise) {
        this.solicitacaoDeAnalise = solicitacaoDeAnalise;
    }

    public StatusAmostra getStatusAmostra() {
        return statusAmostra;
    }

    public void setStatusAmostra(StatusAmostra statusAmostra) {
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

    public Set<Ensaio> getEnsaios() {
        return ensaios;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amostra amostra = (Amostra) o;

        return Objects.equals(idAmostra, amostra.idAmostra);
    }

    @Override
    public int hashCode() {
        return idAmostra != null ? idAmostra.hashCode() : 0;
    }
}

