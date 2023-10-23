package LeetCode.根据规则将箱子分类;

public class Solution {
    public static void main(String[] args) {
        int i=100000;
        System.out.println(new Solution().categorizeBox(100000,100000,100000,3));
    }
    public String categorizeBox(int length, int width, int height, int mass) {
        long tiji = 1;
        tiji = tiji * length * width * height;
//        long tiji=length * width * height;
        boolean ifBulky = false, ifHeavy = false;
        if (length >= 10000 || width >= 10000 || height >= 10000 || tiji >= 1000000000) {
            ifBulky = true;
        }
        if (mass >= 100) {
            ifHeavy = true;
        }
        if (ifBulky && ifHeavy) {
            return "Both";
        } else if (!ifBulky && !ifHeavy) {
            return "Neither";
        } else if (ifBulky && !ifHeavy) {
            return "Bulky";
        } else {
            return "Heavy";
        }
    }
}
