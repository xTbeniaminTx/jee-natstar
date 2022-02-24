package fr.natsystem.tp.data.converter;

import javax.persistence.AttributeConverter;

import fr.natsystem.tp.data.utilities.CouleurEnum;



public class CouleurEnumToStringConverter implements AttributeConverter<CouleurEnum, String>  {
	
    @Override
    public String convertToDatabaseColumn(CouleurEnum value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    @Override
    public CouleurEnum convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return CouleurEnum.getEnum(value);
    }

}
