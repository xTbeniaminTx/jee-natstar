package fr.natsystem.tp.data.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class PrenomCommenceParXValidator implements ConstraintValidator<PrenomCommenceParX, String> {

	public void initialize(String prenom) {
		//
	}

	public boolean isValid(String prenom, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(prenom)) return true;
		if (!StringUtils.startsWith(prenom, "X")) return false; 
		if (prenom.length() < 3) return false;
		return true;
	}
}


