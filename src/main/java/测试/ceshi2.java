package 测试;

import java.util.*;

public class ceshi2 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(100);
        list.add(200);
        list.add(300);
        System.out.println(list);
        list.remove((Integer)100);
        System.out.println(list);
    }
    private Student fixStudent(Student student){
        student.setName("小刘");
        return student;
    }
}
