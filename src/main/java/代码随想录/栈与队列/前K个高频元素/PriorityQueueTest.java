package 代码随想录.栈与队列.前K个高频元素;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTest{
    public static void main(String args[]){
        PriorityQueue<People> queue = new PriorityQueue<People>(11,
                new Comparator<People>() {
                    public int compare(People p1, People p2) {
                        return p2.age - p1.age;
                    }
                });

        for (int i = 1; i <= 10; i++) {
            queue.add(new People("张"+ i, (new Random().nextInt(100))));
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().toString());
        }
        System.out.println("============使用iterater遍历：");
        Iterator<People> iterator = queue.iterator();
        while (iterator.hasNext()){
            People next = iterator.next();
            System.out.println(next);
        }
    }
}

class People {
    String name;
    int age;
    public People(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "姓名："+name + " 年龄：" + age;
    }
}

