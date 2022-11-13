package com.solbs.unoapi.dtos;

/**
 * Classe de transferência de dados utilizada para como modelo para efetuar as operações com a base de dados
 */
public class EnsaioDTO {
    private Long idAmostra;
    private String nomeEnsaio;
    private String especificacao;
    private String resultadoDoEnsaio;

    public Long getIdAmostra() {
        return idAmostra;
    }

    public void setIdAmostra(Long idAmostra) {
        this.idAmostra = idAmostra;
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
}
