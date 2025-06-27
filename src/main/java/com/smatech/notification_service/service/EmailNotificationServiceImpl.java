package com.smatech.notification_service.service;

import com.smatech.notification_service.config.EmailConfig;
import com.smatech.notification_service.request.EmailNotificationRequest;
import com.smatech.notification_service.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service

public class EmailNotificationServiceImpl implements EmailNotificationService {
    private final JavaMailSender emailSender;
    private final String from;

    public EmailNotificationServiceImpl(JavaMailSender emailSender, EmailConfig emailConfig) {
        this.emailSender = emailSender;
        this.from = emailConfig.getUsername();
    }

    @Override
    public Response sendEmailNotification(EmailNotificationRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());
        emailSender.send(message);
        return new Response(200,"", message);
    }
}
