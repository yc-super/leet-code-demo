package test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.ArrayList;
import java.util.List;

public class MemeoryTest {
    List<Dog> dogs = new ArrayList<>();
    public static void main(String[] args) {


        MemeoryTest memeoryTest = new MemeoryTest();
        memeoryTest.memoryTest();
    }

    public void memoryTest(){
        getMemory();
//        List<Dog> dogs = new ArrayList<>();
        for(int i = 0 ;i < 50000; i++){
            Dog dog = new Dog();
            dogs.add(dog);
        }
        System.out.println("==============");
        getMemory();
        Object[] objects = dogs.toArray();
    }

    public void getMemory() {
        StringBuilder builder = new StringBuilder();
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean memoryPoolMXBean : memoryPoolMXBeans) {
            builder.append(memoryPoolMXBean.getName());
            builder.append(" ");
            long used = memoryPoolMXBean.getUsage().getUsed() / (1024*1024);
            builder.append(used);
            builder.append("M");
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public class Dog{
        private String name;
        private String color;
    }
}


