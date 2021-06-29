package com.digisoft.com.digisoftitweb.email.api;

import com.digisoft.com.digisoftitweb.email.module.EmailModule;
import com.digisoft.com.digisoftitweb.utils.base.EmailBaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/mail")
public interface EmailApi {
    @PostMapping("/send")
    ResponseEntity<EmailBaseResponse<?>> sendEmail(@RequestBody EmailModule emailModule);
}
