package fr.natsystem.tp.data.converter;



import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.BooleanUtils;

import fr.natsystem.tp.data.utilities.ConstantesOuiNon;



@Converter
public class BooleanToStringOuiNonConverter  implements AttributeConverter<Boolean, String>  {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return BooleanUtils.toString(value, ConstantesOuiNon.OUI, ConstantesOuiNon.NON, null);
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (value == null) return null;
        return ConstantesOuiNon.OUI.equals(value);
    }

}
