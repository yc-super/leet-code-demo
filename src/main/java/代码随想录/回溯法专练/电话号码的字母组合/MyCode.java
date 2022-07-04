package 代码随想录.回溯法专练.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class MyCode {
    static String[] s;
    public static void main(String[] args) {
        s= new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String ss="234";
        String[] list=new MyCode().combbination(ss);
        System.out.println(list.length);
        for (String s : list) {
            System.out.println(s);
        }
    }
    List<String> res;
    private String[] combbination(String ss) {
        res=new ArrayList<>();
        int len=ss.length();

        String[] strs=new String[len];
        for (int i = 0; i < len; i++) {
            strs[i]=s[Integer.parseInt(String.valueOf(ss.charAt(i)))];
        }

        backTrack(0,0,len,strs,new StringBuilder());
        return res.toArray(new String[0]);
    }

    private void backTrack(int start1,int start2,int len, String[] ss,StringBuilder sb) {
        if(sb.length()==len){
            res.add(sb.toString());
            return;
        }
        for (int i = start1; i < len; i++) {
            for (int j = start2; j < ss[start1].length(); j++) {
                sb.append(ss[i].charAt(j));
                backTrack(i+1, start2, len, ss, sb);
                sb.deleteCharAt(sb.length()-1);
            }

        }
    }
}
