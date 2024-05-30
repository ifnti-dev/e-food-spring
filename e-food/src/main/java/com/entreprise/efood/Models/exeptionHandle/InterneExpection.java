package com.entreprise.efood.Models.exeptionHandle;

public class InterneExpection extends RuntimeException {
    public InterneExpection(String message, Throwable cause) {
        super(message, cause);
    }
}
