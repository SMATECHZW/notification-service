package com.smatech.notification_service.controller;

import com.smatech.notification_service.request.EmailNotificationRequest;
import com.smatech.notification_service.response.Response;
import com.smatech.notification_service.service.EmailNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final EmailNotificationService emailService;

    public NotificationController(EmailNotificationService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/email/send")
    public Response sendEmail(@RequestBody EmailNotificationRequest request) {
        return emailService.sendEmailNotification(request);
    }
}