package fr.natsystem.tp.data.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PrenomCommenceParXValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrenomCommenceParX {
	
	String message() default "La penom doit commence par un X";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
