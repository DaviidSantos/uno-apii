package com.solbs.unoapi.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.solbs.unoapi.entities.customid.IdPrefixado;
import com.solbs.unoapi.entities.enums.StatusAmostra;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amostra_seq")
    @GenericGenerator(name = "amostra_seq", strategy = "com.solbs.unoapi.entities.customid.IdPrefixado",
    parameters = {
        @org.hibernate.annotations.Parameter(name = IdPrefixado.INCREMENT_PARAM, value = "100"),
            @org.hibernate.annotations.Parameter(name = IdPrefixado.VALUE_PREFIX_PARAMETER, value = "AM_"),
            @org.hibernate.annotations.Parameter(name = IdPrefixado.NUMBER_FORMAT_PARAMETER, value = "%05d")
    })
    private String idAmostra;


    @Column(nullable = false)
    private String nomeAmostra;

    @ManyToOne
    @JoinColumn(name = "id_solicitacao_de_analise")
    private SolicitacaoDeAnalise solicitacaoDeAnalise;

    @Column(nullable = false)
    private StatusAmostra statusAmostra;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT")
    private Instant dataDeEntrada;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String notaFiscal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate validade;

    @OneToMany(mappedBy = "amostra")
    private Set<Ensaio> ensaios = new HashSet<>();

    public Amostra() {
    }

    public Amostra(String idAmostra, String nomeAmostra, SolicitacaoDeAnalise solicitacaoDeAnalise, StatusAmostra statusAmostra, Instant dataDeEntrada, String tipo, String notaFiscal, LocalDate validade) {
        this.idAmostra = idAmostra;
        this.nomeAmostra = nomeAmostra;
        this.solicitacaoDeAnalise = solicitacaoDeAnalise;
        this.statusAmostra = statusAmostra;
        this.dataDeEntrada = dataDeEntrada;
        this.tipo = tipo;
        this.notaFiscal = notaFiscal;
        this.validade = validade;
    }

    public String getIdAmostra() {
        return idAmostra;
    }

    public void setIdAmostra(String idAmostra) {
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

