package 回溯法专练.字符串的排列_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code {
    List<String> array;
    boolean[] vis;
    public static void main(String[] args) {
        String s="aba";//abc,acb,bac,bca,cab,cba
        String[] permutation = new code().permutation(s);
        System.out.println(permutation.length);
        for (String ss : permutation) {
            System.out.println(ss);
        }
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        array=new ArrayList<>();
        vis=new boolean[s.length()];
        StringBuilder perm = new StringBuilder();
        backTrack(chars,0,chars.length,perm);
        String[] result=new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i]=array.get(i);
        }
        return result;
    }

    private void backTrack(char[] chars, int i, int n, StringBuilder perm) {
        if(i==n){
            array.add(perm.toString());
        }else{
            for (int j = 0; j < n; j++) {
                if(vis[j]||(j>0&&!vis[j-1]&&chars[j]==chars[j-1])){
                    continue;
                }else{
                    vis[j]=true;
                    perm.append(chars[j]);
                    backTrack(chars,i+1,n,perm);
                    perm.deleteCharAt(perm.length()-1);
                    vis[j]=false;
                }
            }
        }
    }
}
