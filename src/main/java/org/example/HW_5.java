package org.example;

import java.util.HashMap;

public class HW_5 {
    public static void main(String[] args) {

//      Создать множество; ключ и значение - строки.
        HashMap<String, String> hashMap = new HashMap<>();

//      Добавить шесть элементов.
        hashMap.put("один", "one");
        hashMap.put("два", "two");
        hashMap.put("три", "three");
        hashMap.put("четыре", "four");
        hashMap.put("пять", "five");
        hashMap.put("шесть", "six");

//      Вывести в консоль значения.
        System.out.println("\n" + hashMap.values() + "\n");

//      Добавить ко всем значениям символ "!".
        hashMap.forEach((k, v) -> hashMap.merge(k, "!", String::concat));

//      Создать второе множество с таким же обобщением.
        HashMap<String, String> hashMap2 = new HashMap<>();

//      Ключи второго множества частично совпадают с ключами первого.
        hashMap2.put("восемь", "8");
        hashMap2.put("четыре", "4");
        hashMap2.put("девять", "9");
        hashMap2.put("десять", "10");
        hashMap2.put("пять", "5");
        hashMap2.put("один", "1");

//      Объединить значения во втором множестве и первом, если ключи совпадают.
        hashMap2.forEach((k2, v2) ->
                hashMap.forEach((k, v) -> {
                    if (k2.hashCode() == k.hashCode() && k2.equals(k)) {
                        hashMap2.put(k2, v + v2);
                    }
                }));

//      Вывести результат в консоль.
        hashMap2.forEach((k, v) -> System.out.format("%-10s %-1s%n", k, v));
    }
}