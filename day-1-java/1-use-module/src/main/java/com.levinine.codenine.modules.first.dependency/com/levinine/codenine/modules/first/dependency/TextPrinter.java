package com.levinine.codenine.modules.first.dependency;

import com.levinine.codenine.modules.first.dependency.util.Prompt;

public class TextPrinter {

    private Prompt prompt;

    public TextPrinter(String prompt) {
        this.prompt = new Prompt(prompt);
    }

    public void write(String text) {
        System.out.printf("%s > %s\n", this.prompt.get(), text);
    }

}