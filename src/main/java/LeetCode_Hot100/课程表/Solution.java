package LeetCode_Hot100.课程表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length >= numCourses)
            return false;
        Map<Integer, Set<Integer>> map = new HashMap<>(numCourses);
        int[][] array = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            array[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
        int temp=0;
        while (true){
            if(!map.containsKey(temp)){
                method(temp,array,map);

            }
        }
    }

    private void method(int temp,int[][] array,Map<Integer, Set<Integer>> map) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < array[temp].length; i++) {
            if(array[temp][i]==1){
                set.add(array[temp][i]);
            }
        }
        map.put(temp,set);
    }
}
