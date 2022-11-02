package com.solbs.unoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_ensaio")
public class Ensaio {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeEnsaio;
    private String especificacao;
    private String resultadoDoEnsaio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_amostra")
    private Amostra amostra;

    public Ensaio() {
    }

    public Ensaio(Long id, String nomeEnsaio, String especificacao, String resultadoDoEnsaio, Amostra amostra) {
        this.id = id;
        this.nomeEnsaio = nomeEnsaio;
        this.especificacao = especificacao;
        this.resultadoDoEnsaio = resultadoDoEnsaio;
        this.amostra = amostra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEnsaio() {
        return nomeEnsaio;
    }

    public void setNomeEnsaio(String nomeEnsaio) {
        this.nomeEnsaio = nomeEnsaio;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getResultadoDoEnsaio() {
        return resultadoDoEnsaio;
    }

    public void setResultadoDoEnsaio(String resultadoDoEnsaio) {
        this.resultadoDoEnsaio = resultadoDoEnsaio;
    }

    public Amostra getAmostra() {
        return amostra;
    }

    public void setAmostra(Amostra amostra) {
        this.amostra = amostra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ensaio ensaio = (Ensaio) o;

        return Objects.equals(id, ensaio.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
