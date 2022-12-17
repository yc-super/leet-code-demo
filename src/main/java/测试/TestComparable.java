package 测试;

import 测试.比较器.Students2Comparator;

import java.util.*;

public class TestComparable {
    public static void main(String[] args) {
        //数组排序
        Student[] students=new Student[]{
                new Student(3),
                new Student(2),
                new Student(1)
        };
        Arrays.sort(students);//Student已实现Comparable接口，已经内排序了
        System.out.println(Arrays.toString(students));

        Student2[] students2=new Student2[]{
                new Student2(3),
                new Student2(2),
                new Student2(1)
        };
//        Arrays.sort(students2);//不用比较器排序，会报错
        System.out.println(Arrays.toString(students2));
        Arrays.sort(students2,new Students2Comparator());//使用自定义的比较器，有排序效果
        System.out.println(Arrays.toString(students2));

        System.out.println("--------------------");

        //List排序
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(3));
        studentList.add(new Student(2));
        studentList.add(new Student(1));
        Collections.sort(studentList);//Student已实现Comparable接口，已经内排序了
        System.out.println(studentList);

        List<Student2> studentList2=new ArrayList<>();
        studentList2.add(new Student2(3));
        studentList2.add(new Student2(2));
        studentList2.add(new Student2(1));
//        Arrays.sort(students2);//不用比较器排序，会报错
        System.out.println(studentList2);
        Collections.sort(studentList2,new Students2Comparator());//使用自定义的比较器，有排序效果
        System.out.println(studentList2);
    }
}
