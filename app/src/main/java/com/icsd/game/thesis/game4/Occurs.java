package com.icsd.game.thesis.game4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    public Character[] shuffleCharArray(String s) { //pernaei tin parapanw leksi os orisma kai anakateuei ta grammata
//done
       if(s == null)
       {
           return null;
       }
       int len = s.length();
       Character[] array = new Character[len];
       for(int i = 0;i<len;i++)
       {
           array[i] = Character.valueOf(s.charAt[i]);
       }
        List<Character> sh_chars = Arrays.asList(array);
       Collections.shuffle(sh_chars);
       Character[] myShuffledArray = (Character[]) sh_chars.toArray();
       return myShuffledArray;
    }


}

