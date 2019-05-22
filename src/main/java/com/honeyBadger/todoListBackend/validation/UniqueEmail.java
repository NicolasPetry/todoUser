package com.honeyBadger.todoListBackend.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Constraint(validatedBy=UniqueEmailValidator.class)
@NotBlank
@Email
@Size(min=4, max=250)
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueEmail {

	String message() default "{}";
	
	Class[] groups() default {};
	
	Class[] payload() default {};
}
