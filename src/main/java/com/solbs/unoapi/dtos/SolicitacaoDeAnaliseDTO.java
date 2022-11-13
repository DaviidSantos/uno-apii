package com.solbs.unoapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solbs.unoapi.entities.Solicitante;

public class SolicitacaoDeAnaliseDTO {
    private String cnpj;
    private String tipoDeAnalise;
    private String informacoesAdicionais;
    private String consideracoesGerais;

    public SolicitacaoDeAnaliseDTO() {
    }

    public SolicitacaoDeAnaliseDTO(String cnpj, String tipoDeAnalise, String informacoesAdicionais, String consideracoesGerais) {
        this.cnpj = cnpj;
        this.tipoDeAnalise = tipoDeAnalise;
        this.informacoesAdicionais = informacoesAdicionais;
        this.consideracoesGerais = consideracoesGerais;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
}
