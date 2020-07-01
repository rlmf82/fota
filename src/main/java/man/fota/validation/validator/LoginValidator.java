package man.fota.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import man.fota.service.UserService;
import man.fota.validation.LoginAlreadyExist;

public class LoginValidator implements ConstraintValidator<LoginAlreadyExist, String> {

	@Autowired
	UserService service;
	
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	return !service.exist(value);
    }
}
