package com.example.splitting.monolith.exceptions;

public class ResourceAlreadyTakenException extends Exception {
    public ResourceAlreadyTakenException(String message) {
        super(message);
    }
}
