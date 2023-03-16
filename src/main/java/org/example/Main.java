package org.example;

public class Main {
    public static void main(String[] args) {

        char []alphabet = new char[26];
        char c = 'a';
        for (int i = 0; i < 26; i++){
            alphabet[i] = c++;
            System.out.println((int)alphabet[i]);
        }

//        char c = 'A';
//        for (int i = 0; i < 26; i++){
//            alphabet[i] = c++;
//            System.out.println((int)alphabet[i]);
//        }

//        char c = '0';
//        for (int i = 0; i < 10; i++){
//            alphabet[i] = c++;
//            System.out.println((int)alphabet[i]);
//        }

        char[] hoge = "🍣".toCharArray();
        System.out.println("🍣".length());
        System.out.println(hoge[1]);
        System.out.println(hoge[0]);
        System.out.println(hoge[0] + hoge[1]);
        System.out.println(String.valueOf(112543));

    }
}