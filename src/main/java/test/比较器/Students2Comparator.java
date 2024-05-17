package test.比较器;

import test.Student2;

import java.util.Comparator;

public class Students2Comparator implements Comparator<Student2> {
    //11
    @Override
    public int compare(Student2 o1, Student2 o2) {
        if(o1.getAge()>o2.getAge()){
            return 1;
        }else if(o1.getAge()<o2.getAge()){
            return -1;
        }else {
            return 0;
        }
    }
}
