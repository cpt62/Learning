package stepik.tregulov.reflection.example2;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class xiaomiClass = Class.
                forName("stepik.tregulov.reflection.example2.Xiaomi");
        SmartPhone sm1 = (SmartPhone) xiaomiClass.getAnnotation(SmartPhone.class);
        System.out.println("Annotation info from Xiaomi class: " + sm1.OS() + ", " + sm1.yearOfCompanyCreation());

        Class iphoneClass = Class.
                forName("stepik.tregulov.reflection.example2.Iphone");
        SmartPhone sm2 = (SmartPhone) iphoneClass.getAnnotation(SmartPhone.class);
        System.out.println("Annotation info from Iphone class: " + sm2.OS() + ", " + sm2.yearOfCompanyCreation());
    }
}

@Target({ElementType.TYPE}) // Можем использовать для класса или интерфейса
@Retention(RetentionPolicy.RUNTIME) // видим эту аннотацию, используя рефлексию
@interface SmartPhone {
    String OS() default "Android";

    int yearOfCompanyCreation() default 2010;
}

@SmartPhone() // значения не заданы, так как они есть как default в описании аннотации
class Xiaomi {
    String model;
    double price;
}

@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class Iphone {
    String model;
    double price;
}