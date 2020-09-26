package com.company;

public class Processor {
    String str, strNum;
    int decr = 0, incr = 0, mult = 0, div = 0;

    public Processor(String str) {
        this.str = str;
    }

    public String pickUpNumber() {
        int i = 0;
        strNum = "";
        while (i < str.length() && (
                str.charAt(i) == '1' ||
                str.charAt(i) == '2' ||
                str.charAt(i) == '3' ||
                str.charAt(i) == '4' ||
                str.charAt(i) == '5' ||
                str.charAt(i) == '6' ||
                str.charAt(i) == '7' ||
                str.charAt(i) == '8' ||
                str.charAt(i) == '9' ||
                str.charAt(i) == '0')) {
            strNum += str.charAt(i);
            i++;
        }
        return str.substring(i);
    }

    public String pickUpOperand() {
        int i = 0;
        while (str.charAt(i) == ' ' ||
                str.charAt(i) == '+' ||
                str.charAt(i) == '-' ||
                str.charAt(i) == '*' ||
                str.charAt(i) == '/') {
            if (str.charAt(i) == '+') {
                incr++;
            }
            if (str.charAt(i) == '-') {
                decr++;
            }
            if (str.charAt(i) == '*') {
                mult++;
            }
            if (str.charAt(i) == '/') {
                div++;
            }
            i++;
        }
        return str.substring(i);
    }
}
