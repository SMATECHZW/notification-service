package com.smatech.notification_service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private int statusCode;
    private String message;
    private Object data;
    // private List<?> list;
}
