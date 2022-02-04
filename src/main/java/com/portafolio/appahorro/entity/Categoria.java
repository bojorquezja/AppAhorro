package com.portafolio.appahorro.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

@AllArgsConstructor
public enum Categoria {
    COMIDA("CMD"),
    COMPRAS("CMP"),
    VIVIENDA("VVN"),
    TRANSPORTE("TRN"),
    SALUD("SLD"),
    INGRESO("ING");

    @Getter
    private String id;

    public static Categoria fromId(String id){
        return Stream.of(Categoria.values())
                .filter(categoria -> categoria.getId().equals(id) )
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }

}
