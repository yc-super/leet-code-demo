package LeetCode.excel表列名称;

public class MyCode {
    public static void main(String[] args) {
        /*
        * 1 A
        * 2 B
        * 3 C
        * 26  Z
        * 27  AA
        * 52  AZ
        * 701 ZY
        * 702 ZZ
        * 703 AAA
        *
        * */
//        int a=702;
//        int a=26;
        int a=52;
        System.out.println(convertToTitle(a));
//        System.out.println((char)(25+'A'));
    }
    public static String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }

}
