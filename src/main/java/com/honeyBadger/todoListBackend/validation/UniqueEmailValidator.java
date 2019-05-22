package com.honeyBadger.todoListBackend.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.honeyBadger.todoListBackend.repositories.UserRepository;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	private UserRepository userRepository;
	
	public UniqueEmailValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void initialize(UniqueEmail arg0) {
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		return !userRepository.findByEmail(email).isPresent();
	}

}
