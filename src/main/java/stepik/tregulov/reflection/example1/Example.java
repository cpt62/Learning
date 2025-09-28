package stepik.tregulov.reflection.example1;

import java.lang.reflect.Field;

// Использование рефлексии с полями и методами с модификатором доступа private
// Например, поле Salary (сеттер/геттер и конструктор, инициализирующий данное поле закомментированы)
public class Example {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(10, "Zaur", "IT");
        Class empClass = employee.getClass();
        Field salaryField = empClass.getDeclaredField("salary");

        //чтобы дать себе доступ для работы с private полем, пишем следующее:
        salaryField.setAccessible(true); //!!!!
        double salaryValue = (Double) salaryField.get(employee);
        System.out.println(salaryValue);

        //Меняем заработную плату сотрудника
        salaryField.set(employee, 1500);
        System.out.println(employee);
    }
}
