package 代码随想录.回溯法专练.字符串的排列_offer;

import java.util.*;

/*
* 所有组合方式
* */
public class code1 {
    int k=0;
    public static void main(String[] args) {
        String s="aab";//abc,acb,bac,bca,cab,cba
        String[] permutation = new code1().permutation(s);
        System.out.println(permutation.length);
        for (String ss : permutation) {
            System.out.println(ss);
        }
    }
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int n=factorial(s.length());
        String[] result=new String[n];
        Set columns=new HashSet<Integer>();
        char[] index = new char[chars.length];
        backTrack(result,0,chars,columns,index);
        return result;
    }

    private void backTrack(String[] result, int row, char[] chars,Set columns,char[] index) {
        if(row==chars.length){
            result[k++] = String.valueOf(index);
        }else {
            for (int i = 0; i < chars.length; i++) {
                if(columns.contains(i)){
                    continue;
                }
                index[row]=chars[i];
                columns.add(i);
                backTrack(result,row+1,chars,columns,index);
                index[row]='a';
                columns.remove(i);
            }
        }
    }

    private int factorial(int n){
        if(n==0)
            return 0;
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
