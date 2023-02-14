package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayListImpl<String> myArrayList = new MyArrayListImpl<String>();

        myArrayList.add("val1");
        myArrayList.add("val2");
        myArrayList.add("val3");
        myArrayList.add("val4");
        myArrayList.add("val5");
        myArrayList.add("val6");
        myArrayList.add("val7");
        myArrayList.add("val8");
        myArrayList.add("val9");
        myArrayList.add("val10");
        myArrayList.add("val11");

        myArrayList.add(0, "newVal1");

        boolean result1 = myArrayList.contains("newVal1");
        boolean result2 = myArrayList.contains("noContainVal");
        System.out.println("contains " + result1);
        System.out.println("contains " + result2);

        String  result3 = myArrayList.get(0);
        System.out.println("get " + result3);

        String  result4 = myArrayList.remove(0);
        System.out.println("remove " + result4);

        Object[] result5 = myArrayList.toArray();
        System.out.println("toArray " + result5);

        int result6 = myArrayList.size();
        System.out.println("size " + result6);
    }
}