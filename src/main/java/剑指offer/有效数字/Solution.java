package 剑指offer.有效数字;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validNumber("-."));
    }

    // 自己想的，没什么难的，主要是要细心，把所有可能的情况都考虑进去。
    // 题解中用的是有限自动机
    public boolean validNumber(String s) {
        String str = s.trim();
        int count1 = 0;// .的数量
        int count2 = 0;// e或E的数量
        int count3 = 0;// +或-的数量
        int index = -1;// e或者E下标
        int index1 = -1;// .下标
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'a' && c < 'e') || (c > 'e' && c <= 'z') || (c >= 'A' && c < 'E') || (c > 'E' && c <= 'Z'))
                return false;
            if (c == ' ')
                return false;
            if (c == '.') {
                count1++;
                index1 = i;
            }
            if (count1 > 1)
                return false;
            if (c == 'e' || c == 'E') {
                count2++;
                index = i;
            }
            if (count2 > 1)
                return false;
            if (c == '-' || c == '+')
                count3++;
            if (count3 > 2)
                return false;
        }
        if (count2 == 0 && count3 > 1)
            return false;
        if (index != -1) {
            // 有e
            return checkIfB(str, index + 1, str.length() - 1, index1) && (checkIfA(str, 0, index - 1, count1, index1,count3) || checkIfB(str, 0, index - 1, index1));
        } else {
            // 没有e
            return checkIfA(str, 0, str.length() - 1, count1, index1,count3) || checkIfB(str, 0, str.length() - 1, index1);
        }
    }

    // 是否是整数
    private boolean checkIfB(String str, int i, int j, int index) {
        if (j - i < 0)
            return false;
        if (index >= i && index <= j)
            return false;
        char c = str.charAt(i);
        if (j == i) {
            if (c == '+' || c == '-')
                return false;
            return c >= '0' && c <= '9';
        } else {
            if (!(c == '+' || c == '-' || (c >= '0' && c <= '9')))
                return false;
            i++;
            while (i <= j) {
                c = str.charAt(i);
                if (!(c >= '0' && c <= '9'))
                    return false;
                i++;
            }
        }
        return true;
    }

    // 是否是小数
    private boolean checkIfA(String str, int i, int j, int count, int index,int count2) {
        if (count != 1)
            return false;
        if(count2==0) {
            if (j - i < 1)
                return false;
        }else{
            if (j - i < 2)
                return false;
        }
        if (index < i || index > j)
            return false;
        char cc = str.charAt(i);
        if (!(cc == '+' || cc == '-'|| cc == '.' || (cc >= '0' && cc <= '9')))
            return false;
        i++;
        for (int k = i; k < index; k++) {
            char c = str.charAt(k);
            if (c < '0' || c > '9')
                return false;
        }
        for (int k = index + 1; k <= j; k++) {
            char c = str.charAt(k);
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }
}
