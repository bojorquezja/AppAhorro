package com.portafolio.appahorro.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
public enum Tipo {
    GASTO("G"),
    INGRESO("I");

    @Getter
    private String id;

    public static Tipo fromId(String id){
        return Stream.of(Tipo.values())
                .filter(tipo -> tipo.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
