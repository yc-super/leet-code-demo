package LeetCode.供暖器;

//import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class code {
    public static void main(String[] args) {
//        int[] houses = {1,2,3};
//        int[] heaters = {2};//1
//        int[] houses = {1,2,3,4};
//        int[] heaters = {1,4};//1
//        int[] houses = {1,5};
//        int[] heaters = {2};//3
//        int[] houses = {1,5};
//        int[] heaters = {10};//9
        int[] houses = {9,10};
        int[] heaters = {1};//9
        System.out.println(new code().findRadius2(houses,heaters));

    }

    //写了很久，代码超级啰嗦，看着就不像能AC的样子
    public int findRadius(int[] houses, int[] heaters) {
        int minMax=0;
        int left=0;
        int right=0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            //1,2,3,4  1,4
            for (int j = heaters.length-1; j >=0; j--) {
                if(heaters[j]>houses[i])
                    continue;
                if(heaters[j]==houses[i]){
                    left=0;
                    break;
                }else {
                    while (heaters[j] != houses[i] - left) {
                        if (houses[i] - left < 0) {
                            break;
                        }
                        left++;
                    }
                }
                if(houses[i]-left>=0) {
                    break;
                }
            }
            for (int j = 0; j < heaters.length; j++) {
                if(heaters[j]<houses[i])
                    continue;
                right=0;
                while(heaters[j]!=houses[i]+right){
                    if(houses[i]+right>heaters[heaters.length-1]){
                        break;
                    }
                    right++;
                }
                if(houses[i]+right<=heaters[heaters.length-1]){
//                    minMax = Math.max(minMax, right);
                    break;
                }
            }
            int indexValue=0;
            if(left==0){
                indexValue=right==0?0:right;
            }
            if(right==0){
                indexValue=left==0?0:left;
            }
            if(left!=0&&right!=0){
                indexValue=Math.min(left,right);
            }
            minMax=Math.max(minMax, indexValue);
            right=0;
        }
        return minMax;
    }
    public int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max=0;
        int i=0;
        int n=heaters.length;
        for(int house:houses){
            while(i<n&&house>heaters[i]){
                i++;
            }
            if(i==0)
                max=Math.max(max,heaters[i]-house);
            else if(i==n)
                max=Math.max(max,house-heaters[i-1]);
            else
                max=Math.max(max,Math.min(heaters[i]-house,house-heaters[i-1]));
        }
        return max;
    }
}
