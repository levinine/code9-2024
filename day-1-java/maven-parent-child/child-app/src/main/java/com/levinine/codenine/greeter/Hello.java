package com.levinine.codenine.greeter;

import org.apache.commons.lang3.StringUtils;

import com.levinine.codenine.util.EmptyNameException;

public class Hello {

    public String greet(String name) throws EmptyNameException {
        if (StringUtils.isBlank(name)) {
            throw new EmptyNameException();
        } else {
            return StringUtils.join("Hello", " ", name);
        }
    }
}