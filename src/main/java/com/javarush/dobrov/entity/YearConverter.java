package com.javarush.dobrov.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Year year) {
        if(year!=null){
            return year.getValue();
        }
        return null;
    }

    @Override
    public Year convertToEntityAttribute(Integer integer) {
        if(integer!=null) {
            return Year.of(integer);
        }
        return null;
    }

}
