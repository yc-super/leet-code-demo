package Hot100.括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution1_copy {
    public static void main(String[] args) {
        Solution1_copy Solution1_copy = new Solution1_copy();
        List<String> list = Solution1_copy.generateParenthesis(3);
        System.out.println(list);
    }

    public static List<String> generateParenthesis(int n){
        List<String> list=new ArrayList<>();
        backTrack(list,new StringBuilder(),n,0,0);
        return list;
    }

    private static void backTrack(List<String> list,  StringBuilder sb,int n,int left,int right) {
        if(sb.length()==n*2){
            list.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            backTrack(list,sb,n,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            backTrack(list,sb,n,left,right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
