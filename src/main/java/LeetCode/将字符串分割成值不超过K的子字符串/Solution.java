package LeetCode.将字符串分割成值不超过K的子字符串;

public class Solution {
    public int minimumPartition(String s, int k) {
        char[] chars = s.toCharArray();
        long curNum=0;
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]-'0'>k){
                return -1;
            }
            if(curNum<=k) {
                if (curNum == 0) {
                    curNum = chars[i] - '0';
                } else {
                    curNum *= 10;
                    curNum += chars[i] - '0';
                    if(curNum>k){
                        count++;
                        curNum=chars[i]-'0';
                    }
                }
            }else{
                count++;
                curNum=chars[i]-'0';
            }
        }
        if(curNum<=k)
            count++;
        return count;
    }
}
