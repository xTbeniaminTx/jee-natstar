package fr.natsystem.tp.data.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateDansLePasseValidator implements ConstraintValidator<DateDansLePasse, LocalDate> {

	public void initialize(LocalDate date) {
        // initialisation si nécessaire
    }

    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {

        if (date == null) return true;
        return date.isBefore(LocalDate.now());

    }

}
