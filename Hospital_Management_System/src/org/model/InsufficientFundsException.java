package org.model;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String msg){
        super(msg);
    }
}
