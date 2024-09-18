package com.lucaschumacher;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordGenerator {

    private static final List<String> VOWELS = List.of("a", "e", "i", "o", "u", "ü");
    private static final List<String> CONSONANTS = List.of("b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "v", "w", "z", "ch", "sch", "tz", "pf");


    public String generateText(int length) {
        //generate connecting words
        List<String> connectingWords = new ArrayList<>();
        int connectingWordsAmount = 15;

        for (int i = 0; i < connectingWordsAmount; i++) {
            Random random = new Random();
            int wordLength = random.nextInt(4) + 3;
            connectingWords.add(generateWord(wordLength));
        }

        //generate other words
        List<String> otherWords = new ArrayList<>();
        int otherWordsAmount = connectingWordsAmount * 10;

        for (int i = 0; i < otherWordsAmount; i++) {
            Random random = new Random();
            int wordLength = random.nextInt(6) + 4;
            otherWords.add(generateWord(wordLength));
        }

        //generate text with connecting words, other words and random punctuation
        Random random = new Random();
        boolean isConnectingWord = random.nextBoolean();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (isConnectingWord) {
                text.append(connectingWords.get(random.nextInt(connectingWordsAmount)));
            } else {
                text.append(otherWords.get(random.nextInt(otherWordsAmount)));
            }

            if (random.nextInt(10) == 0) {
                text.append(", ");
            } else if (random.nextInt(20) == 0) {
                text.append(". ");
            } else if (random.nextInt(30) == 0) {
                text.append("! ");
            } else if (random.nextInt(40) == 0) {
                text.append("? ");
            } else {
                text.append(" ");
            }

            isConnectingWord = !isConnectingWord;
        }


        return text.toString();
    }

    public String generateWord(int length) {
        Random random = new Random();
        StringBuilder word = new StringBuilder();
        boolean isVowel = random.nextBoolean();

        for (int i = 0; i < length; i++) {
            if (isVowel) {
                word.append(VOWELS.get(random.nextInt(VOWELS.size())));
            } else {
                word.append(CONSONANTS.get(random.nextInt(CONSONANTS.size())));
            }
            isVowel = !isVowel;
        }

        return word.toString();
    }


}
