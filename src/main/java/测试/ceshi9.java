package 测试;

import java.text.DecimalFormat;
import java.util.*;

public class ceshi9 {
    public static void main(String[] args) {
//        double x1 = 501078.869440198;
//        double y1 = -589246.114488788;
//        double z1 = 45843352.2183258;
//        501078.869440198,-589246.114488788,45843352.2183258
//        19701078.8694402,-589246.114488788,45843352.2183258
//        20101078.8694402,-455912.781155455,45843352.2183258中心点
//        19701.0788694402,-589.246114488788,45843.3522183258


       /* double x1 = 20101078.8694402;
        double y1 =-455912.781155455;
        double z1 = 45843352.2183258;


        double x2 = 19701.0788694402;
        double y2 = -589.246114488788;
        double z2 = 45843.3522183258;
        double length = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
        System.out.println(length/100);*/

       String a=",abc,def,";
        if( a.lastIndexOf(",")==a.length()-1){
            System.out.println();
            a = a.substring(0,a.length() - 1);
            System.out.println(a);
        }
        if(a.indexOf(",")==0){
            a=a.substring(1);
        }
        System.out.println(a);

        //19.2
        //0.4216
        //50
    }
}
