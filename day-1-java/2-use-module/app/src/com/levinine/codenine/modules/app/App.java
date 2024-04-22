package com.levinine.codenine.modules.app;

import com.levinine.codenine.modules.greeting.open.OpenGreeting;

public class App {

    public static void main(String[] args) throws NoSuchFieldException {
        var greeting = new OpenGreeting("Strale");
        greeting.greet();

        var field = OpenGreeting.class.getDeclaredField("name");
        System.out.println(field.getType());
    }

}
