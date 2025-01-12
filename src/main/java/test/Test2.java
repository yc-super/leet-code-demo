package test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test2 {
    public static void main(String[] args) {
        new ConcurrentHashMap<>();
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        System.out.println(objects);
        CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>(objects);
        objects1.remove("3");
        System.out.println(objects1);
        System.out.println(objects);

    }
}
