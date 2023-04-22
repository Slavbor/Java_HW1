package org.example;


public class HW_2 {
    public static void main(String[] args) {

        System.out.println("\n\n Задание 1. \n");
        System.out.println(parse_from_string("-5 в степени 3 = "));
        System.out.println(parse_from_string("основание 111, степень 2 = "));
        System.out.println(parse_from_string("основание 26 в степени 5 = "));
        System.out.println(parse_from_string("4 в степени 7 = "));
        System.out.println(parse_from_string("2 в степени 10 = "));
        System.out.println(parse_from_string("основание 3 в степени 7 = "));


        System.out.println("\n\n Задание 2. Сравнение скорости работы string и StringBuilder \n\n");
        String my_string = """
                            Lorem ipsum dolor sit dolor, consectetur adipiscing dolor dolor sit amet,
                            consectetur dolor elit ipsum dolor sit dolor, consectetur dolor elit
                            ipsum dolor sit dolor, consectetur dolor elit ipsum dolor sit amet,
                            dolor adipiscing elit.
                """;
        String query = "dolor";
//        double begin = System.currentTimeMillis();
        double begin = timeCalc();
        System.out.println("Начальный текст: \n" + my_string);
        System.out.println(my_string.replace(query, "Lorem"));
//        double end = System.currentTimeMillis();
        double end = timeCalc();

        System.out.println("Время выполнения через string: " + (end - begin) + " Nanoseconds" );
        System.out.println();

        begin = timeCalc();
        StringBuilder sb = new StringBuilder(my_string);
        while (sb.indexOf(query) > 0) {
            sb.replace(sb.indexOf(query), sb.indexOf(query) + query.length(), "Lorem");
        }
        System.out.println(sb);
        end = timeCalc();
        System.out.println("Время выполнения через stringBuilder: " + (end - begin) + " Nanoseconds" );
    }

    public static double timeCalc() {
        return System.nanoTime();
    }


    public static String parse_from_string(String in_string) {
        String[] strings = in_string.split(" ");
        int base = 0;
        int power = 0;
        double product = 0;
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replace(",", "");
            try {
                Integer.parseInt(strings[i]);
                if (base == 0) {
                    base = Integer.parseInt(strings[i]);
                } else {
                    power = Integer.parseInt(strings[i]);
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        product = Math.pow(base, power);
        return in_string + " " + String.valueOf(product);
    }
}
   