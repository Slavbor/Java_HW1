package org.example;

import java.io.*;
import java.util.*;


public class HW_4 {

    public static void main(String[] args) throws Exception {
        System.out.println("\n 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader");
        String txt_file = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

        FileWriter fw = new FileWriter("test_java_txt.txt");
        fw.write(txt_file);
        fw.close();

        FileReader fr = new FileReader("test_java_txt.txt");
        System.out.println("\nТекст из файла: ");
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            System.out.print(scan.nextLine());
        }


        scan.close();
        fr.close();


        System.out.println("\n\n 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате \"Иванов И.И. 32 М\" \n ");

        fr = new FileReader("people.txt");
        scan = new Scanner(fr);
        ArrayList<String> people_list = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            people_list.add(line);
            System.out.println(line);
        }

        fr.close();

        System.out.println("\n 3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках");

        ArrayList<Integer> list_id = new ArrayList<>();
        ArrayList<String> family_name = new ArrayList<>();
        ArrayList<String> first_name = new ArrayList<>();
        ArrayList<String> second_name = new ArrayList<>();
        ArrayList<Integer> people_age = new ArrayList<>();
        ArrayList<String> sex = new ArrayList<>();

        Iterator<String> iterator = people_list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String line = iterator.next();
            list_id.add(i);
            i++;
            family_name.add(line.split(" ")[0]);
            first_name.add(line.split(" ")[1]);
            second_name.add(line.split(" ")[2]);
            people_age.add(Integer.parseInt(line.split(" ")[3]));
            sex.add(line.split(" ")[4]);

        }
        System.out.println("Список фамилий: " + family_name);
        System.out.println("Список имен: " + first_name);
        System.out.println("Список отчеств: " + second_name);
        System.out.println("Список возрастов: " + people_age);
        System.out.println("Список полов: " + sex);

        System.out.println("\n 4.Отсортировать по возрасту используя дополнительный список индексов.");
        List<Integer> age = new ArrayList<Integer>(people_age);
        for (i = 0; i < people_age.size(); i++) {
            int temp = 0;
            //int min_age = list_age.get(i);
            for (int j = 1; j < people_age.size(); j++) {
                if (age.get(j) > age.get(j - 1)) {
                    temp = age.get(j);
                    age.set(j, age.get(j - 1));
                    age.set(j - 1, temp);

                    temp = list_id.get(j);
                    list_id.set(j, list_id.get(j - 1));
                    list_id.set(j - 1, temp);
                }
            }

        }

        for (i = 0; i < people_age.size(); i++) {
            System.out.print(family_name.get(list_id.get(i)) + " ");
            System.out.print(first_name.get(list_id.get(i)) + " ");
            System.out.print(second_name.get(list_id.get(i)) + " ");
            System.out.print(people_age.get(list_id.get(i)) + " ");
            System.out.print(sex.get(list_id.get(i)) + " ");
            System.out.println();
        }
    }
}