package schildt.annotation.example_2;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Пример, когда параметр метода содержит аргументы.

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();

    int val();
}

class Meta {
    @MyAnno(str = "Два параметра", val = 19)
    public static void myMeth(String str, int i) {
        Meta ob = new Meta();
        try {
            Class<?> c = ob.getClass();
            // здесь указываются типы параметров
            Method m = c.getMethod("myMeth", String.class, int.class);
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exception) {
            System.out.println("Метод не найден.");
        }
    }

    public static void main(String[] args) {
        myMeth("Test", 10);
    }
}
