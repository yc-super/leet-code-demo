package 其他.华为od;

import java.util.Scanner;

public class 最小的调整次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        int count = 0;
        for (int i = 0; i < num*2; i++) {
            String s = in.nextLine();
            if (s.indexOf("tail") >= 0)
                count++;
        }
        System.out.println(count);
    }
}
/*
* 20
    10 2 8
    5 12 3
    3 7 10

    total=24
    2 4 6 3 4 4 1
    6 4 4 4 3 2 1

    2
    3不行
    4不行
    6不行
    8不行
    *
    * 最小的调整次数  MVP争夺战 区间连接器
* */