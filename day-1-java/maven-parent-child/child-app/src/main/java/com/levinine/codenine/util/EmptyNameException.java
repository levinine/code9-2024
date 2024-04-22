package com.levinine.codenine.util;

public class EmptyNameException extends Exception {
    
    public EmptyNameException() {
        super("Provided name can not be empty");
    }

}
