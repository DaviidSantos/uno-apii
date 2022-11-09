package com.solbs.unoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_solicitacao_de_analise")
public class SolicitacaoDeAnalise {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSA;

    @Column(nullable = false)
    private String tipoDeAnalise;
    private String informacoesGerais;
    private String consideracoesGerais;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cnpj_solicitante")
    private Solicitante solicitante;

    @OneToMany(mappedBy = "solicitacaoDeAnalise")
    private Set<Amostra> amostras = new HashSet<>();

    public SolicitacaoDeAnalise() {
    }

    public SolicitacaoDeAnalise(Long idSA, String tipoDeAnalise, String informacoesGerais, String consideracoesGerais, Solicitante solicitante) {
        this.idSA = idSA;
        this.tipoDeAnalise = tipoDeAnalise;
        this.informacoesGerais = informacoesGerais;
        this.consideracoesGerais = consideracoesGerais;
        this.solicitante = solicitante;
    }

    public Long getIdSA() {
        return idSA;
    }

    public void setIdSA(Long idSA) {
        this.idSA = idSA;
    }

    public String getTipoDeAnalise() {
        return tipoDeAnalise;
    }

    public void setTipoDeAnalise(String tipoDeAnalise) {
        this.tipoDeAnalise = tipoDeAnalise;
    }

    public String getInformacoesGerais() {
        return informacoesGerais;
    }

    public void setInformacoesGerais(String informacoesGerais) {
        this.informacoesGerais = informacoesGerais;
    }

    public String getConsideracoesGerais() {
        return consideracoesGerais;
    }

    public void setConsideracoesGerais(String consideracoesGerais) {
        this.consideracoesGerais = consideracoesGerais;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Set<Amostra> getAmostras() {
        return amostras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolicitacaoDeAnalise that = (SolicitacaoDeAnalise) o;

        return Objects.equals(idSA, that.idSA);
    }

    @Override
    public int hashCode() {
        return idSA != null ? idSA.hashCode() : 0;
    }
}
