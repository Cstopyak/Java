package com.colbystopyak.beltevent.validators;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.colbystopyak.beltevent.models.User;
import com.colbystopyak.beltevent.services.UserService;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserService uServ;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
        User user = (User) target;
//      CHECK TO SEE IF PASSWORD AND CONFIRM PASSWORD MATCH
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }
//      CHECK TO SEE IF EMAIL IS UNIQUE IN DB
        if(uServ.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("duplicate", "Dupe");
        }
		
	}
	
}