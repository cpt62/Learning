package stepik.eskova.lambda.section_3.part_4;

//Нужно создать отображение (Map), где каждому целому числу (типа Integer) ставится в соответствие вещественное число (типа Double).
// На вход поступают строки, в которых может быть два числа (целое и вещественное), либо одно число (целое неотрицательное).
// В первом случае пара добавляется в отображение как ключ и значение.
// Во втором случае это ключ, а значение рассчитывается как факториал этого числа (но только в том случае, если в отображении еще нет такого ключа).
// Если уже такой ключ присутствует в отображении, то информация в нем не изменяется.

// Содержимое отображения затем нужно вывести на консоль в формате: ключ:значение.

// Рекомендуется использовать метод Map, который получает в параметр функцию в виде лямбда-выражения.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Double> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        while (!(str = scanner.nextLine()).equals("end")) {
            String[] arr = str.split(" ");
            if (arr.length == 2) {
                map.put(Integer.parseInt(arr[0]), Double.parseDouble(arr[1]));
            } else {
                map.computeIfAbsent(Integer.parseInt(arr[0]), k -> {
                    double result = 1;
                    for (int i = 1; i <= k; i++) {
                        result *= i;
                    }
                    return result;
                });
            }
        }
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}


