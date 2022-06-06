package Hot100.课程表;

import java.util.*;

public class MyCode {
    public static void main(String[] args) {
        int numCourses = 2;
//        int[][] prerequisites = {{1,0},{0,1}};
        int[][] prerequisites = {{0,1},{1,2},{2,3},{3,4},{4,5}};
        System.out.println(MyCode.canFinish(numCourses,prerequisites));
    }
    /*
     * 0     1       2       3       4       5
     * 3    2,4,5    5,4    1,2     5,2      3,2,1
     *
     * */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0)
            return true;
        List<Set<Integer>> list=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> set=new HashSet<>();
            list.add(set);
        }
        canFinish2(list,prerequisites,numCourses,new HashSet<>());


        return false;
    }

    private static void canFinish2(List<Set<Integer>> list, int[][] prerequisites, int numCourses, HashSet<Object> hashSet) {
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> set = list.get(prerequisites[i][0]);

        }
    }
}
