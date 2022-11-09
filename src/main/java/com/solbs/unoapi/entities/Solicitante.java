package com.solbs.unoapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_solicitante")
public class Solicitante implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(updatable = false)
    private String cnpj;

    @Column(name = "nome_solicitante", nullable = false)
    private String nomeSolicitante;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(name = "telefone_comercial",nullable = false)
    private String telefoneComercial;

    @Column(name = "email_comercial",nullable = false)
    private String emailComercial;

    @OneToMany(mappedBy = "solicitante")
    private Set<SolicitacaoDeAnalise> solicitacoesDeAnalise = new HashSet<>();

    public Solicitante() {
    }

    public Solicitante(String cnpj, String nomeSolicitante, String cep, String endereco, String cidade, String estado, String telefoneComercial, String emailComercial) {
        this.cnpj = cnpj;
        this.nomeSolicitante = nomeSolicitante;
        this.cep = cep;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.telefoneComercial = telefoneComercial;
        this.emailComercial = emailComercial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getEmailComercial() {
        return emailComercial;
    }

    public void setEmailComercial(String emailComercial) {
        this.emailComercial = emailComercial;
    }

    public Set<SolicitacaoDeAnalise> getSolicitacoesDeAnalise() {
        return solicitacoesDeAnalise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solicitante that = (Solicitante) o;

        return Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return cnpj != null ? cnpj.hashCode() : 0;
    }
}
