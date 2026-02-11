package com.tss.string;

import java.util.Scanner;

public class EncoderDecoder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = scanner.next();

        while(true){
            if(str.contains("@") || str.contains("!") || str.contains("*") || str.contains("$")){
                System.out.print("Enter valid string which should not contain (@,!,*,$): ");
                str=scanner.next();
            }else{
                break;
            }
        }

        System.out.println("Encoded String: " + encoder(str));
        System.out.println("Decoded Version: " + decoder(encoder(str)));

    }

    public static String encoder(String str) {
        StringBuilder strBuilder = new StringBuilder(str.toLowerCase());

        for (int i = 0; i < strBuilder.length(); i++) {
            char charAtN = strBuilder.charAt(i);
            if (charAtN == 'a') {
                strBuilder.setCharAt(i, '@');
            } else if (charAtN == 'i') {
                strBuilder.setCharAt(i, '!');
            } else if (charAtN == 'o') {
                strBuilder.setCharAt(i, '*');
            } else if (charAtN == 'u') {
                strBuilder.setCharAt(i, '$');
            } else if (charAtN == 'z') {
                strBuilder.setCharAt(i, 'a');
            } else if (charAtN > 97 && charAtN < 122) {
                strBuilder.setCharAt(i, ((char) ((charAtN + 1))));
            }
        }
        return strBuilder.reverse().toString();

    }

    public static String decoder(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();

        for (int i = 0; i < strBuilder.length(); i++) {
            char charAtN = strBuilder.charAt(i);
            if (charAtN == '@') {
                strBuilder.setCharAt(i, 'a');
            } else if (charAtN == '!') {
                strBuilder.setCharAt(i, 'i');
            } else if (charAtN == '*') {
                strBuilder.setCharAt(i, 'o');
            } else if (charAtN == '$') {
                strBuilder.setCharAt(i, 'u');
            } else if (charAtN == 'a') {
                strBuilder.setCharAt(i, 'z');
            } else if (charAtN > 97 && charAtN < 122) {
                strBuilder.setCharAt(i, ((char) ((charAtN - 1))));
            }
        }

        return strBuilder.toString();
    }
}
