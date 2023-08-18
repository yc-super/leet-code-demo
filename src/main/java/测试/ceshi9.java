package 测试;

import java.text.DecimalFormat;
import java.util.*;

public class ceshi9 {
    public static void main(String[] args) {
        String s="(1234)";
        System.out.println(s.substring(s.indexOf("(")+1,s.indexOf(")")));
    }
}
