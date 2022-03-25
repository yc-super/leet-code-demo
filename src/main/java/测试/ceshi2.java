package 测试;

import java.math.BigDecimal;
import java.util.*;

public class ceshi2 {
    public static void main(String[] args) {
       String s="123";
        Double aDouble = Double.valueOf(s);
        double d=Double.valueOf(s);
        BigDecimal b=BigDecimal.valueOf(d).setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println();
    }
    private Student fixStudent(Student student){
        student.setName("小刘");
        return student;
    }
}
