package com.lucaschumacher;

import java.util.List;

public class RWGMain {
    public static void main(String[] args) {
        RWGMain main = new RWGMain();
        main.run();
    }

    public void run() {
        System.out.println("Running WordGenerator...");
        WordGenerator wordGenerator = new WordGenerator();
        String text = wordGenerator.generateText(300);

        System.out.println(text);
    }
}