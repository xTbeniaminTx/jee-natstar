package fr.natsystem.tp.data.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class PrenomCommenceParXValidator implements ConstraintValidator<PrenomCommenceParX, String> {

	@Override
	public boolean isValid(String prenom, ConstraintValidatorContext context) {
		
			return (!StringUtils.startsWith(prenom, "X"));
		
	}

}
