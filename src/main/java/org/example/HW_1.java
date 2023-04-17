package org.example;

import java.util.ArrayList;

public class HW_1 {
    public static void main(String[] args) {
        //1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        int i = (int) (Math.random() * (1000 - (-1000))) + (-1000);
        System.out.print("\n");
        System.out.println("Случайное число i: " + i);
        System.out.print("\n");

        //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        String temp = Integer.toBinaryString(i);
        System.out.println("Случайное число в двоичной системе: " + temp);
        System.out.print("\n");
        int n = temp.length();
        System.out.println("Старший значащий бит n стоит на позиции " + n);
        System.out.print("\n");

        //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        ArrayList<Integer> arrayListDivisible = new ArrayList<>();
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                arrayListDivisible.add(j);
            }
        }
        int[] m1 = new int[arrayListDivisible.size()];
        for (int j = 0; j < arrayListDivisible.size(); j++) {
            m1[j] = arrayListDivisible.get(j);
        }
        //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        ArrayList<Integer> arrayListNonDivisible = new ArrayList<>();
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                arrayListNonDivisible.add(j);
            }
        }

        int[] m2 = new int[arrayListNonDivisible.size()];
        for (int j = 0; j < arrayListNonDivisible.size(); j++) {
            m2[j] = arrayListNonDivisible.get(j);
        }
//        System.out.print("\n");
//        System.out.print("массив m1: \n");
//        print_array(m1);
//        System.out.print("\n");
//        System.out.print("\n");
//        System.out.print("массив m2: \n");
//        print_array(m2);
    }


    public static void print_array(int[] in_array) {
        for (int i : in_array) System.out.print("|" + i + "|");
    }
}