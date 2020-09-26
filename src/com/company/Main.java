package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String abc, remaining1, remaining2, remaining3;
        int a, b;
        boolean wrongData = false;

        System.out.println("Input: ");
        abc = input.nextLine().trim().toUpperCase();

        //проверяем арабские или римские
        ArabicOrRoman arOrRom = new ArabicOrRoman(abc);
        if (arOrRom.check() == true) {

            //арабские. отделяем 1й блок с цифрами
            Processor processor1 = new Processor(abc);
            remaining1 = processor1.pickUpNumber();
            a = Integer.parseInt(processor1.strNum);

            //отделяем блок с операторами, в качестве параметра принимаем огрызок строки
            //оставшийся после отделения 1го блока с цифрами
            Processor processor2 = new Processor(remaining1);
            remaining2 = processor2.pickUpOperand();

            //отделяем 2й блок с цифрами, в качестве параметра принимаем огрызок строки
            //оставшийся после отделения блока с операторами
            Processor processor3 = new Processor(remaining2);
            remaining3 = processor3.pickUpNumber();
            b = Integer.parseInt(processor3.strNum);

            //проверяем, что после 2го блока цифр больше ничего не написано
            if (remaining3.length() >= 1) {
                wrongData = true;
            }

            //проверяем, чтобы числа не были меньше 1 и больше 10
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                wrongData = true;
            }

            //выбор математического действия с проверкой на одновременную встречу нескольких операторов
            if (wrongData == false) {
                int i = processor2.incr, d = processor2.decr, m = processor2.mult, di = processor2.div;
                if (i == 1 && d == 0 && m == 0 && di == 0) {
                    System.out.println("Output: \n" + (a + b));
                } else if (d == 1 && i == 0 && m == 0 && di == 0) {
                    System.out.println("Output: \n" + (a - b));
                } else if (m == 1 && i == 0 && d == 0 && di == 0) {
                    System.out.println("Output: \n" + (a * b));
                } else if (di == 1 && i == 0 && d == 0 && m == 0) {
                    System.out.println("Output: \n" + (a / b));
                } else
                    wrongData = true;
            }

            if (wrongData == true) System.out.println("wrong data");

        } else {
            //римские. отделяем 1й блок римских цифр
            int i = 0;
            String strNum1 = "";
            while (i < abc.length() && (
                    abc.charAt(i) == '1' ||
                            abc.charAt(i) == 'X' ||
                            abc.charAt(i) == 'I' ||
                            abc.charAt(i) == 'V')) {
                strNum1 += abc.charAt(i);//1й блок с римскими цифрами
                i++;
            }
            remaining1 = abc.substring(i);

            //отделяем блок с операторами, в качестве параметра принимаем огрызок строки
            //оставшийся после отделения 1го блока с цифрами
            Processor processor2 = new Processor(remaining1);
            remaining2 = processor2.pickUpOperand();

            //отделяем 2й блок с цифрами
            i = 0;
            String strNum2 = "";
            while (i < remaining2.length() && (
                    remaining2.charAt(i) == '1' ||
                            remaining2.charAt(i) == 'X' ||
                            remaining2.charAt(i) == 'I' ||
                            remaining2.charAt(i) == 'V')) {
                strNum2 += remaining2.charAt(i);//2й блок с римскими цифрами
                i++;
            }
            remaining3 = remaining2.substring(i);

            //проверяем, что после 2го блока цифр больше ничего не написано
            if (remaining3.length() >= 1) {
                wrongData = true;
            }

            //перевод римских в арабские
            Rom rom1 = new Rom(strNum1);
            a = rom1.selectMatch();//первое число
            Rom rom2 = new Rom(strNum2);
            b = rom2.selectMatch();//второе число

            //если вместо римских цифр написана белиберда
            if (a == 0 || b == 0) {
                wrongData = true;
            }
            if (wrongData == true) {
                System.out.println("wrong data");
            } else {
                //выбор математического действия с проверкой на одновременную встречу нескольких операторов
                    i = processor2.incr;
                    int d = processor2.decr, m = processor2.mult, di = processor2.div;
                    FromArabicToRoman toRoman = new FromArabicToRoman();

                    if (i == 1 && d == 0 && m == 0 && di == 0) {
                        System.out.println("Output: \n" + toRoman.turnToRoman(a + b));
                    } else if (d == 1 && i == 0 && m == 0 && di == 0) {
                        System.out.println("Output: \n" + toRoman.turnToRoman(a - b));
                    } else if (m == 1 && i == 0 && d == 0 && di == 0) {
                        System.out.println("Output: \n" + toRoman.turnToRoman(a * b));
                    } else if (di == 1 && i == 0 && d == 0 && m == 0) {
                        System.out.println("Output: \n" + toRoman.turnToRoman(a / b));
                    } else System.out.println("wrong data");
            }
        }
    }
}
