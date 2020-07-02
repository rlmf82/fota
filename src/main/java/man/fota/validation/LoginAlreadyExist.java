package man.fota.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import man.fota.validation.validator.LoginValidator;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginValidator.class)
@Documented
public @interface LoginAlreadyExist {

    String message() default "Login already being used.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}