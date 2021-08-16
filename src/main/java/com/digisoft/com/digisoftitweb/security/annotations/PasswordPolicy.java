package com.digisoft.com.digisoftitweb.security.annotations;

import com.digisoft.com.digisoftitweb.security.annotations.validator.PasswordPolicyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordPolicyValidator.class)

public @interface PasswordPolicy {
    String message() default "Password is not valid.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}