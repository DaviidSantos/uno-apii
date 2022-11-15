package com.solbs.unoapi.entities.enums;

public enum StatusAmostra {
    ANÁLISE_FINALIZADA(1),
    EM_ANÁLISE(2),
    AGUARDANDO_ANÁLISE(3),
    AMOSTRA_EM_FALTA(4);

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
