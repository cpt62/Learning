package schildt.annotation.example_1;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Объявление аннотации типа.

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

class Meta {
    //Аннотировать метод
    @MyAnno(str = "Пример аннотации", val = 100)
    public static void myMeth() {
        Meta ob = new Meta();
        //получить аннотацию для этого метода
        //и отобразить значения ее членов.
        try {
            //Для начала получить объект класс,
            //который представляет данный класс.
            Class<?> c = ob.getClass();

            //Теперь получить объект метод,
            //который представляет данный класс.
            Method m = c.getMethod("myMeth");

            //Далее получить аннотацию для этого класса.
            MyAnno anno = m.getAnnotation(MyAnno.class);

            //В заключение вывести значения.
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exception) {
            System.out.println("Метод не найден.");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
