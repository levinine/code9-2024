package com.levinine.codenine.modules.greeting.open;

public class OpenGreeting {

    private String name;

    public OpenGreeting(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello " + name);
    }

}
