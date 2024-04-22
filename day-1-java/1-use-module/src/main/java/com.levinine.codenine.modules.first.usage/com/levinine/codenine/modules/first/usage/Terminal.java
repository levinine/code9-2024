package com.levinine.codenine.modules.first.usage;

import com.levinine.codenine.modules.first.dependency.TextPrinter;

public class Terminal {

    public static void main(String[] args) {
        var ourClass = new Terminal("s.dobrijevic");
        ourClass.write("Hello");
        ourClass.write("world");
    }

    private TextPrinter printer;

    public Terminal(String prompt) {
        this.printer = new TextPrinter(prompt);
    }

    public void write(String text) {
        this.printer.write(text);
    }
}