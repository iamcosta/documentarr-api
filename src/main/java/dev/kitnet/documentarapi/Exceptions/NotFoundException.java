package dev.kitnet.documentarapi.Exceptions;

public class NotFoundException extends BusinessException{
    public NotFoundException(String message) {
        super(message);
    }
}
