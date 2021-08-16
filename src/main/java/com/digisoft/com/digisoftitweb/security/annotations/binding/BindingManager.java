package com.digisoft.com.digisoftitweb.security.annotations.binding;

import com.digisoft.com.digisoftitweb.security.exception.PasswordRulesException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class BindingManager {

    public void bindingCheck(BindingResult  bindingResult){
        if (bindingResult.hasErrors())throw new PasswordRulesException();
    }
}
