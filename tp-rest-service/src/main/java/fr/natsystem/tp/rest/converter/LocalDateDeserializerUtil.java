package fr.natsystem.tp.rest.converter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializerUtil  extends StdDeserializer<LocalDate>  {
    protected LocalDateDeserializerUtil(JavaType valueType) {
		super(valueType);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -7290264815546912415L;
    
    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        LocalDate result = null;
        try {
            if (jsonParser.getValueAsString().length() > 10) {
                result = LocalDateTime.parse(jsonParser.getValueAsString()).toLocalDate();
            }
            else {
                result = LocalDate.parse(jsonParser.getValueAsString());
            }
        } catch (Exception e) {
            throw new IOException("parsing de LocalDate en String impossible " + e.getMessage());
        }
        return result;
    }

}