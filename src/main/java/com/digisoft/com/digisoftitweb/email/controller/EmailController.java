package com.digisoft.com.digisoftitweb.email.controller;

import com.digisoft.com.digisoftitweb.email.api.EmailApi;
import com.digisoft.com.digisoftitweb.email.module.EmailModule;
import com.digisoft.com.digisoftitweb.email.service.impl.EmailServiceImpl;
import com.digisoft.com.digisoftitweb.utils.base.EmailBaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EmailController implements EmailApi {
    private final EmailServiceImpl emailService;

    @Override
    public ResponseEntity<EmailBaseResponse<?>> sendEmail(EmailModule emailModule) {
        boolean isEmailSent = emailService.sendHtmlMessage(emailModule);
        log.info("Email sent {} ", isEmailSent);
        EmailBaseResponse<?> response = new EmailBaseResponse<>(new Date(), isEmailSent,HttpStatus.ACCEPTED);
        return new ResponseEntity<>(response, response.getHttpStatus());

    }
}
