package com.company;

public class Rom {
    String s;

    Rom(String s) {
        this.s = s;
    }

    int selectMatch() {
        int Num=0;
        switch (s) {
            case ("I"):
                Num = 1;
                break;
            case ("II"):
                Num = 2;
                break;
            case ("III"):
                Num = 3;
                break;
            case ("IV"):
                Num = 4;
                break;
            case ("V"):
                Num = 5;
                break;
            case ("VI"):
                Num = 6;
                break;
            case ("VII"):
                Num = 7;
                break;
            case ("VIII"):
                Num = 8;
                break;
            case ("IX"):
                Num = 9;
                break;
            case ("X"):
                Num = 10;
                break;
        }
        return Num;
    }
}
