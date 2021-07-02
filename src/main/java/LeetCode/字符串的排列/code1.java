package LeetCode.字符串的排列;

import java.util.*;
/*
* 所有组合方式
* */
public class code1 {
    public static void main(String[] args) {
        String s="abc";//abc,acb,bac,bca,cab,cba
        /*
        * abcd
        * abcd,abdc,acbd,acdb,adbc,dacb
        *
        * */
        System.out.println(permutation(s));
    }

    //递归+回溯
    public static String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }
    public static void dfs(char[] arr, String s,  boolean[] visited, Set<String> list)
    {
        if(s.length() == arr.length)
        {
            list.add(s);
            return;
        }
        for(int i=0; i<arr.length; i++)
        {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(arr, s+String.valueOf(arr[i]), visited, list);
            visited[i] = false;
        }

    }


    //剪枝？？
    public String[] permutation2(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        boolean[] visited = new boolean[s.length()];
        List<String> res = new ArrayList<>();
        dep(stack, top, s, visited, res);
        return res.toArray(new String[0]);
    }
    void dep(char[] stack, int top, String s, boolean[] visited, List<String> res) {
        if(top == s.length()-1) {
            res.add(new String(stack));
            return;
        }
        Map<Character,Integer> hisMap = new HashMap<>();
        for(int i =0;i<s.length();i++) {
            if(visited[i]) {
                continue;
            }
            if(hisMap.size() != 0 && hisMap.get(s.charAt(i)) != null) {
                continue;
            }
            visited[i] = true;
            stack[++top] = s.charAt(i);
            dep(stack, top, s, visited, res);
            visited[i] = false;
            hisMap.put(stack[top--],1);
        }
    }
}
