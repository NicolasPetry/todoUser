package com.honeyBadger.todoListBackend.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.honeyBadger.todoListBackend.models.User;

public class RetypePasswordValidator implements ConstraintValidator<RetypePassword, User> {

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {

		if (Objects.equals(user.getPassword(), user.getRetypePassword()))
			return true;
					
		return false;
	}

}
