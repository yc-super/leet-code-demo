package LeetCode.老人的数目;

public class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String str : details) {
            if ((str.charAt(11) - '6' == 0 && str.charAt(12) - '0' > 0) || (str.charAt(11) - '6' > 0 && str.charAt(12) - '0' >= 0))
                count++;
        }
        return count;
    }
}
