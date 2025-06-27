package com.smatech.notification_service.service;

import com.smatech.notification_service.request.EmailNotificationRequest;
import com.smatech.notification_service.response.Response;

public interface EmailNotificationService {
    Response sendEmailNotification(EmailNotificationRequest request);
}
