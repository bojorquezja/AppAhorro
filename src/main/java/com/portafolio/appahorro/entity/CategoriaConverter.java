package com.portafolio.appahorro.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CategoriaConverter implements AttributeConverter<Categoria, String> {
    @Override
    public String convertToDatabaseColumn(Categoria attribute) {
        return attribute.getId();
    }

    @Override
    public Categoria convertToEntityAttribute(String dbData) {
        return Categoria.fromId(dbData);
    }
}
