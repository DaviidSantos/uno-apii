package com.solbs.unoapi.entities.enums;

public enum StatusAmostra {
    Análise_Finalizada(1),
    Em_Análise(2),
    Aguardando_Análise(3),
    Amostra_em_Falta(4);

    private int code;

    StatusAmostra(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusAmostra valor(int code){
        for(StatusAmostra value: StatusAmostra.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código de status inválido");
    }
}
