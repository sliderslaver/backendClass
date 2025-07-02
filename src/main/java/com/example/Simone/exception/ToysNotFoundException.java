package com.example.Simone.exception;

public class ToysNotFoundException extends RuntimeException{
    public ToysNotFoundException(){}
    public ToysNotFoundException(String message){super(message);}
}
