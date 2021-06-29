package com.digisoft.com.digisoftitweb.email.service.impl;

import com.digisoft.com.digisoftitweb.email.module.EmailModule;
import com.digisoft.com.digisoftitweb.email.service.EmailService;
import com.digisoft.com.digisoftitweb.utils.templates.EmailTemplates;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("EmailService")
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final EmailTemplates emailTemplates;
    private static final String NOREPLY_ADDRESS = "info@digisoft-it.com";
    private static final String CC_ADDRESS = "shantkh@mail.com";
    private final JavaMailSender emailSender;

    @Value("classpath:/static/img/digiSoft_bg.png")
    private Resource resourceFile;

    public boolean sendSimpleMessage(EmailModule emailModule) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModule.getFrom());
            message.setTo(NOREPLY_ADDRESS);
            message.setSubject(emailModule.getSubject());
            message.setText(emailModule.getText());

            emailSender.send(message);
        } catch (MailException e) {
            log.error("Email sent exception {} ", e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean sendMessageWithAttachment(EmailModule emailModule) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            // pass 'true' to the constructor to create a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailModule.getFrom());
            helper.setTo(NOREPLY_ADDRESS);
            helper.setSubject(emailModule.getSubject());
            helper.setText(emailModule.getText());

            FileSystemResource file = new FileSystemResource(new File(emailModule.getAttachment()));
            helper.addAttachment("Invoice", file);

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            log.error("Email sent exception {} ", e.getMessage());
            return false;
        }
        return true;
    }


    @Override
    @SneakyThrows
    public boolean sendHtmlMessage(EmailModule emailModule) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(emailModule.getFrom());
            helper.setTo(NOREPLY_ADDRESS);
            helper.setSubject(emailModule.getSubject());

            String emailTemplate = emailTemplates.webMailTemplateToDigiSoft(emailModule.getText());
            helper.setText(emailTemplate, true);
            //helper.setCc(CC_ADDRESS);
//            helper.addInline("attachment.png", resourceFile);
            emailSender.send(message);
        } catch (Exception e) {
            log.error("Email sent exception {} ", e.getMessage());
            return false;
        }
        return true;
    }

}