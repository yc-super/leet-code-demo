package LeetCode.最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)==' ') {
                i--;
            }else{
                break;
            }
        }
        int count=0;
        while(i>=0&&s.charAt(i)!=' '){
            i--;
            count++;
        }
        return count;
    }
}
