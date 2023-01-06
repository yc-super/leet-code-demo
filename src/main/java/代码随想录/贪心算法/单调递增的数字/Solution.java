package 代码随想录.贪心算法.单调递增的数字;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(332));
    }

    //自己想的，类似常识题的贪心
    public int monotoneIncreasingDigits(int n) {
        String s=String.valueOf(n);
        int temp=Integer.valueOf(s.charAt(0));
        int i=1;
        for (; i < s.length(); i++) {
            if(temp>Integer.valueOf(s.charAt(i))){
                break;
            }
            temp=Integer.valueOf(s.charAt(i));
        }
        if(i>=s.length())
            return n;
        i--;
        if(i==0){
            int i1 = n / (int) Math.pow(10, s.length() - 1);
            i1*=(int) Math.pow(10, s.length() - 1);
            i1--;
            return i1;
        }
        while(i>=1){

            if(Integer.valueOf(s.charAt(i))-1>=Integer.valueOf(s.charAt(i-1))){
                int i1 = n / (int) Math.pow(10, s.length() - 1-i);
                i1*=Math.pow(10, s.length() - 1-i);
                i1--;
                return i1;
            }else{
                i--;
            }
        }
        if(i==0){
            int i1 = n / (int) Math.pow(10, s.length() - 1);
            i1*=(int) Math.pow(10, s.length() - 1);
            i1--;
            return i1;
        }
        return n;
    }

    //代码随想录，思路和我差不多，代码简洁多了
    public int monotoneIncreasingDigits2(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int start = chars.length;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
