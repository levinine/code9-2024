package com.levinine.codenine;

import com.levinine.codenine.greeter.Hello;
import com.levinine.codenine.util.EmptyNameException;

public class App 
{
    public static void main(String[] args) throws EmptyNameException {
        Hello hello = new Hello();
        String greeting = hello.greet("colleague");
        System.out.println(greeting);
    }
}
