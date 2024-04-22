package com.levinine.codenine.greeter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.levinine.codenine.util.EmptyNameException;

public class HelloTest {

    @Test
    @DisplayName("When we have to greet a NULL or empty name")
    public void greetWithBlankInput() {
        final Hello hello = new Hello();
        assertThrows(EmptyNameException.class, () -> {
            hello.greet(null);
        });
        assertThrows(EmptyNameException.class, () -> {
            hello.greet("");
        });
    }

    @Test
    @DisplayName("When we have to greet an actual name")
    public void greetWithNullInput() throws EmptyNameException {
        final Hello hello = new Hello();
        String output = hello.greet("happy people");
        assertEquals("Hello happy people", output);
    }

}