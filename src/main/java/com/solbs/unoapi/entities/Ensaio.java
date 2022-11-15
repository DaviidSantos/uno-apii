package com.solbs.unoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solbs.unoapi.entities.customid.IdPrefixado;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidade ensaio
 */
@Entity
@Table(name = "tb_ensaio")
public class Ensaio {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ensaio_seq")
    @GenericGenerator(name = "ensaio_seq", strategy = "com.solbs.unoapi.entities.customid.IdPrefixado",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdPrefixado.INCREMENT_PARAM, value = "100"),
                    @org.hibernate.annotations.Parameter(name = IdPrefixado.VALUE_PREFIX_PARAMETER, value = "EN_"),
                    @org.hibernate.annotations.Parameter(name = IdPrefixado.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id;

    @Column(nullable = false)
    private String nomeEnsaio;

    @Column(nullable = false)
    private String especificacao;
    private String resultadoDoEnsaio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_amostra")
    private Amostra amostra;

    public Ensaio() {
    }

    public Ensaio(String id, String nomeEnsaio, String especificacao, String resultadoDoEnsaio, Amostra amostra) {
        this.id = id;
        this.nomeEnsaio = nomeEnsaio;
        this.especificacao = especificacao;
        this.resultadoDoEnsaio = resultadoDoEnsaio;
        this.amostra = amostra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
