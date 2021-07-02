package LeetCode.二进制手表;

import java.util.ArrayList;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {

    }
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn)
                    list.add(i+":"+(j<10?"0":"")+j);
            }
        }
        return list;
    }
    public static List<String> readBinaryWatch2(int turnedOn) {
        List<String> list=new ArrayList<>();

        for (int i = 0; i <= 1024; i++) {
            int h=i>>6;
            int l=i&63;
            if(h<12&&l<60&&Integer.bitCount(i)==turnedOn)
                list.add(h+(l<10?"0":"")+l);
        }
        return list;
    }
}
