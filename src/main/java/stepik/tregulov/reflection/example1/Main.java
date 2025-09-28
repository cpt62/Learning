package stepik.tregulov.reflection.example1;

//Примеры использования рефлексии

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("stepik.tregulov.reflection.example1.Employee");
            Constructor<Employee> constructor1 = employeeClass.getConstructor();
            Employee obj1 = constructor1.newInstance();


            Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
            Object obj2 = constructor2.newInstance(5, "Zaur", "IT");

            Method method1 = employeeClass.getMethod("setSalary", double.class);
            method1.invoke(obj2, 800.88);
            System.out.println(obj2);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}