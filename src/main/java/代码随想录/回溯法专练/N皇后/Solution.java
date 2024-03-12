package 代码随想录.回溯法专练.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);
        System.out.println();
    }
    private List<List<String>> res;
    private LinkedList<String> path;
    String[][] entity;
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        path=new LinkedList<>();
        entity=new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(entity[i],".");
        }
        backTrack(0);
        return res;
    }

    //其实可以不用维护path这个字段，后面start到n的时候，再把entity加入到res中就好
    private boolean backTrack(int start) {
        if(start==entity.length){
            res.add(new ArrayList<>(path));
            return false;
        }
        boolean flag=true;
        for (int i = 0; i < entity.length; i++) {
            for (int j = 0; j < start; j++) {
                if(entity[j][i].equals("Q")){
                    flag=false;
                    break;
                }
            }
            if(!flag){
                flag=true;
                continue;
            }
            int temp=i-1;
            for (int j = start-1; j >=0&&temp>=0; j--) {
                if(entity[j][temp].equals("Q")){
                    flag=false;
                    break;
                }
                temp--;
            }
            if(!flag){
                flag=true;
                continue;
            }
            temp=i+1;
            for (int j = start-1; j >=0&&temp<entity.length; j--) {
                if(entity[j][temp].equals("Q")){
                    flag=false;
                    break;
                }
                temp++;
            }
            if(!flag){
                flag=true;
                continue;
            }
            entity[start][i]="Q";
            path.add(getString(i,entity.length));
            if(backTrack(start+1)){
                return true;
            }else{
                path.removeLast();
                entity[start][i]=".";
                flag=true;
                continue;
            }
        }
        return false;
    }

    private String getString(int i,int n) {
        String res="";
        for (int j = 0; j < i; j++) {
            res+=".";
        }
        res+="Q";
        for (int j = i+1; j < n; j++) {
            res+=".";
        }
        return res;
    }


    public List<List<String>> solveNQueens2(int n) {
        res=new ArrayList<>();
        path=new LinkedList<>();
        used=new boolean[n];
        one=new String[n];
        entity=new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                entity[i][j]=".";
            }
        }
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[i]='Q';
            one[i]=new String(chars);
        }
        backTrack2(0);
        return res;
    }

    private boolean[] used;
    private String[] one;
    private boolean backTrack2(int start) {
        if(start==entity.length){
            res.add(new ArrayList<>(path));
            return false;
        }
        boolean flag=true;
        for (int i = 0; i < entity.length; i++) {
            if(used[i]){
                continue;
            }
            int temp=i-1;
            for (int j = start-1; j >=0&&temp>=0; j--) {
                if(entity[j][temp].equals("Q")){
                    flag=false;
                    break;
                }
                temp--;
            }
            if(!flag){
                flag=true;
                continue;
            }
            temp=i+1;
            for (int j = start-1; j >=0&&temp<entity.length; j--) {
                if(entity[j][temp].equals("Q")){
                    flag=false;
                    break;
                }
                temp++;
            }
            if(!flag){
                flag=true;
                continue;
            }
            entity[start][i]="Q";
            used[i]=true;
            path.add(one[i]);
            if(backTrack2(start+1)){
                return true;
            }else{
                path.removeLast();
                entity[start][i]=".";
                used[i]=false;
                flag=true;
                continue;
            }
        }
        return false;
    }
}
