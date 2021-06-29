package com.digisoft.com.digisoftitweb.email.service;

import com.digisoft.com.digisoftitweb.email.module.EmailModule;

public interface EmailService {
    boolean sendSimpleMessage(EmailModule emailModule);

    boolean sendMessageWithAttachment(EmailModule emailModule);

    boolean sendHtmlMessage(EmailModule emailModule);
}
