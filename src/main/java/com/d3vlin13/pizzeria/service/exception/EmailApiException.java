package com.d3vlin13.pizzeria.service.exception;

public class EmailApiException extends RuntimeException {
    public EmailApiException() {
        super("Error sending email");
    }
}
