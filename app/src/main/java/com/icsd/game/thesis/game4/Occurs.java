package com.icsd.game.thesis.game4;

import java.util.ArrayList;
import java.util.Random;

public class Occurs {

    private String pattern;
    private String phrases;

    public Occurs(String pattern, ArrayList<String> phrase) {
        this.pattern = pattern;
        phrase = new ArrayList<String>();
    }
//df
    public Occurs() {
    }
// asfkjadfksf
    //zzz
//uyihi
    public String get_pattern() {
        return pattern;
    }

    public String PickPhrases(ArrayList<String> correct) { //epilegei mia tuxaia leksei
        String ChosenWord = " ";
        int index = 0;
        Random rand = new Random();
        for (int i = 0; i < correct.size(); i++) {
            if (index != correct.size() && correct.get(index) != null) {
                index = rand.nextInt(18 - 1) + 1;
                ChosenWord = correct.get(index);
            }
        }
        return ChosenWord;
    }

    public char[] shuffleCharArray(String s) { //pernaei tin parapanw leksi os orisma kai anakateuei ta grammata
        char[] tobeshuffled;
        ArrayList<Character> characters = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(s.length());
        while (characters.size() != 0) {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }
        return tobeshuffled = output.toString().replaceAll(" ", "").toCharArray();
    }


}

