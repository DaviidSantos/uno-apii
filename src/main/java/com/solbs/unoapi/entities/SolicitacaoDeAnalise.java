package com.solbs.unoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solbs.unoapi.entities.customid.IdPrefixado;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_solicitacao_de_analise")
public class SolicitacaoDeAnalise {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sa_seq")
    @GenericGenerator(name = "sa_seq", strategy = "com.solbs.unoapi.entities.customid.IdPrefixado",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = IdPrefixado.INCREMENT_PARAM, value = "100"),
                    @org.hibernate.annotations.Parameter(name = IdPrefixado.VALUE_PREFIX_PARAMETER, value = "SA_"),
                    @org.hibernate.annotations.Parameter(name = IdPrefixado.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String idSA;
    private String tipoDeAnalise;
    private String consideracoesGerais;

    private String informacoesAdicionais;


    @ManyToOne
    @JoinColumn(name = "cnpj_solicitante")
    private Solicitante solicitante;

    @JsonIgnore
    @OneToMany(mappedBy = "solicitacaoDeAnalise")
    private Set<Amostra> amostras = new HashSet<>();

    public SolicitacaoDeAnalise() {
    }

    public SolicitacaoDeAnalise(String idSA, String tipoDeAnalise, String informacoesAdicionais, String consideracoesGerais, Solicitante solicitante) {
        this.idSA = idSA;
        this.tipoDeAnalise = tipoDeAnalise;
        this.consideracoesGerais = consideracoesGerais;
        this.informacoesAdicionais = informacoesAdicionais;
        this.solicitante = solicitante;
    }

    public String getIdSA() {
        return idSA;
    }

    public void setIdSA(String idSA) {
        this.idSA = idSA;
    }

    public String getTipoDeAnalise() {
        return tipoDeAnalise;
    }

    public void setTipoDeAnalise(String tipoDeAnalise) {
        this.tipoDeAnalise = tipoDeAnalise;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
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
