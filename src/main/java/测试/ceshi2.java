package 测试;

import java.util.ArrayList;
import java.util.List;

public class ceshi2 {
    public static void main(String[] args) {
        /*Student student = new Student();
        student.setId("123");
        student.setName("小杨");
        Student s2=new ceshi2().fixStudent(student);
        System.out.println(s2);
        System.out.println(student);*/
        List<Student> list=new ArrayList<>();
        List<Student> list2=new ArrayList<>();
        List<Student> list3=new ArrayList<>();
        list2.add(new Student("小明"));
        list.addAll(list3);
        System.out.println(list);
    }
    private Student fixStudent(Student student){
        student.setName("小刘");
        return student;
    }
}
