package com.solbs.unoapi.entities.enums;

public enum Cargos {
    ADMIN(1),
    ANALISTA(2),
    VENDEDOR(3),
    EXPEDICAO(4),
    SUPERVISOR(5);

    private int code;

    Cargos(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Cargos valor(int code){
        for(Cargos value: Cargos.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código do cargo inválido!");
    }
}
