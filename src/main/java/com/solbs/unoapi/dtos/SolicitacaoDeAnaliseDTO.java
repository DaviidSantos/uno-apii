package com.solbs.unoapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solbs.unoapi.entities.Solicitante;

public class SolicitacaoDeAnaliseDTO {
    private String tipoDeAnalise;
    private String informacoesGerais;
    private String consideracoesGerais;
    private String cnpj;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
