package com.company;

public class ArabicOrRoman {
    String s;
    boolean arabic = false;

    ArabicOrRoman(String s) {
        this.s = s;
    }

    public boolean check() {
        char ch = s.charAt(0);
        if (ch =='X' || ch=='I' || ch=='V'){
            arabic=false;
        }else arabic=true;
        return arabic;
    }
}

