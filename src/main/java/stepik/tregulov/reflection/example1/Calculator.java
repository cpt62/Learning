package stepik.tregulov.reflection.example1;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
    void sum(int a, int b) {
        int result = a + b;
        System.out.println("Сумма " + a + " и " + b + " = " + result);
    }

    void subtraction(int a, int b) {
        int result = a - b;
        System.out.println("Разница " + a + " и " + b + " = " + result);
    }

    void multiplication2(int a, int b) {
        int result = a * b;
        System.out.println("Произведение " + a + " и " + b + " = " + result);
    }

    void division(int a, int b) {
        int result = a / b;
        System.out.println("Частное " + a + " и " + b + " = " + result);
    }
}

class TestCalculator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("test100.txt"))) {
            String methodName = reader.readLine();
            String firstArgument = reader.readLine();
            String secondArgument = reader.readLine();

            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();
            Method method = null;
            Method[] methods = cl.getDeclaredMethods();
            for (Method m : methods) {
                if (m.getName().equals(methodName))
                    method = m;
            }
        method.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));
        } catch (IOException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
