package LeetCode.回溯法专练.复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
        String s = "25525511135";
        //输出：["255.255.11.135","255.255.111.35"]
        List<String> result=new MyCode().restoreIpAddresses(s);
        for (String ss :
                result) {
            System.out.println(ss);

        }
    }
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res=new ArrayList<>();

        backTrack(s,0,new StringBuilder(),0);

        return res;

    }

    private void backTrack(String s,int start,StringBuilder sb,int sum){
        if(sum==4){
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        String str;
        if(sum==3) {
            str= s.substring(start);
            if(judge(str)){
                sb.append(str);
                res.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < s.length()&&s.length()-i+1>=(4-sum); i++) {
            str = s.substring(start, i + 1);
            if(judge(str)) {
                sb.append(str).append(".");
                sum++;
                backTrack(s,i+1,sb,sum);
                sum--;
                if(sb.indexOf(".")==sb.lastIndexOf(".")){
                    sb.delete(0,sb.length());
                }else{
                    sb.deleteCharAt(sb.length()-1);
                    sb.delete(sb.lastIndexOf(".") + 1, sb.length());
                }
            }else{
                break;
            }
        }

    }

    private boolean judge(String str) {
        if(str.charAt(0)=='0'&&str.length()>1)
            return false;
        int sum=0;
        for (int i = 0; i < str.length(); i++) {
            int a=str.charAt(i)-'0';
            if(a>9||a<0)
                return false;
            sum=sum*10+a;
            if(sum>255||sum<0)
                return false;
        }
        return true;

    }
}
