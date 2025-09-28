package schildt.annotation.example_4;

import java.lang.annotation.*;
import java.lang.reflect.*;

//Одноэлементная аннотация

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
    int value(); // именем члена должно быть value
}

public class Single {
    //Аннотировать метод, используя одноэлементную аннотацию.
    @MySingle(100)
    public static void myMeth() {
        Single ob = new Single();
        try {
            Method m = ob.getClass().getMethod("myMeth");
            MySingle anno = m.getAnnotation(MySingle.class);
            System.out.println(anno.value());
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
