package com.company;

public class FromArabicToRoman {


    public String turnToRoman(int x) {
        String result = "";
        if (x / 10 == 0) result += "";
        if (x / 10 == 1) result += "X";
        if (x / 10 == 2) result += "XX";
        if (x / 10 == 3) result += "XXX";
        if (x / 10 == 4) result += "XL";
        if (x / 10 == 5) result += "L";
        if (x / 10 == 6) result += "LX";
        if (x / 10 == 7) result += "LXX";
        if (x / 10 == 8) result += "LXXX";
        if (x / 10 == 9) result += "XC";
        if (x % 10 == 0) result += "";
        if (x % 10 == 1) result += "I";
        if (x % 10 == 2) result += "II";
        if (x % 10 == 3) result += "III";
        if (x % 10 == 4) result += "IV";
        if (x % 10 == 5) result += "V";
        if (x % 10 == 6) result += "VI";
        if (x % 10 == 7) result += "VII";
        if (x % 10 == 8) result += "VIII";
        if (x % 10 == 9) result += "IX";
        if (x==100)result+="C";
        return result;
    }
}
