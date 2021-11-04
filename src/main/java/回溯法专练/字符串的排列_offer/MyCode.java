package 回溯法专练.字符串的排列_offer;

import java.util.*;

public class MyCode {
    public static void main(String[] args) {
        String ss="aab";
//        System.out.println(permutation(ss));
        String[] res=permutation(ss);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }
    }

    private static String[] permutation(String ss) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        boolean[] vis=new boolean[ss.length()];
        char[] chars = ss.toCharArray();
        Arrays.sort(chars);

        operate(chars,0,res,vis,sb);

        return res.toArray(new String[0]);
    }

    private static void operate(char[] chars, int row, List<String> res, boolean[] vis, StringBuilder sb) {
        if(row==chars.length){
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            int a=sb.length();
            if(vis[i]||(i>0&&!vis[i-1]&&chars[i-1]==chars[i]))
                continue;

            vis[i]=true;
            sb.append(chars[i]);

            operate(chars,row+1,res,vis,sb);

            sb.deleteCharAt(sb.length()-1);
            vis[i]=false;
        }
    }
}
