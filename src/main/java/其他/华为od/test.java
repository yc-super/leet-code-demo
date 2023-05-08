package 其他.华为od;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int index = str.lastIndexOf(" ");
        String str2 = str.substring(index + 1);
        System.out.println(str2.length());
    }
}
