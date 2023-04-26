package org.example;

import java.util.*;

public class HW_3 {

    public static void main(String[] args) {
//1 Реализовать алгоритм обратной сортировки списков компаратором.
        System.out.println("1. Реализовать алгоритм обратной сортировки списков компаратором.");
        ArrayList<Integer> list_to_sort = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list_to_sort.add(new Random().nextInt(25));
        }
        System.out.println("Список: " + list_to_sort);

        list_to_sort.sort(Comparator.reverseOrder());
        System.out.println("Отсортированый список: " + list_to_sort);


//2   Пусть дан произвольный список целых чисел, удалить из него чётные числа
        System.out.println("\n" + "2 Пусть дан произвольный список целых чисел, удалить из него чётные числа");
        ArrayList<Integer> first_list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            first_list.add(new Random().nextInt(25));
        }
        System.out.println(first_list);

        first_list.removeIf(n -> n % 2 == 0);
        System.out.println("Отфильтрованый список: " + first_list);

//3 Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        System.out.println("\n" + "3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.");
        int min = first_list.get(0);
        int max = min;
        double average = .0;
        int sum = 0;
        System.out.println("Список:" + first_list);
        for (int n : first_list) {
            sum = sum + n;
            if (n > max) max = n;
            if (n < min) min = n;
        }
        average = (double) sum / first_list.size();
        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
        System.out.println("Cреднее: " + average);

//4 Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
        System.out.println("\n" + "4 Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.");
        ArrayList<Integer> second_list = new ArrayList<>();
        List<Integer> crosslist = new ArrayList<Integer>(first_list);
        for (int i = 0; i < 10; i++) {
            second_list.add(new Random().nextInt(25));
        }
        System.out.println("Список 1 = " + first_list);
        System.out.println("Список 2 = " + second_list);
        crosslist.retainAll(second_list);
        first_list.removeAll(crosslist);
        second_list.removeAll(crosslist);
        first_list.addAll(second_list);
        System.out.println("Объединенный список: " + first_list);


//5 Создать ArrayList <Integer> и добавить нулевым эллементом ноль 10000 раз.                 
        System.out.println("\n" + "5 Создать ArrayList <Integer> и добавить нулевым эллементом ноль 10000 раз.");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            first_list.add(0, 0);
        }
        long finish = System.currentTimeMillis();
        System.out.println(first_list);
        System.out.println("Время выполнения: " + (finish - start) + " миллисек.");

//6 Повторить пятый пункт но с LinkedList.
        System.out.println("\n" + "6 Повторить пятый пункт но с LinkedList");
        LinkedList<Integer> LinkedList_array = new LinkedList<>();
        LinkedList_array.add(1);
        long begin_linked = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            LinkedList_array.add(0, 0);
        }
        long end_linked = System.currentTimeMillis();
        System.out.println(LinkedList_array);
        System.out.println("Время выполнения: " + (end_linked - begin_linked) + " миллисек.");
    }
}