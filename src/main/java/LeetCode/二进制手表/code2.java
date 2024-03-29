package LeetCode.二进制手表;

import java.util.ArrayList;
import java.util.List;
/*
* 回溯法
* 效率比较高的一种解法
* */
public class code2 {
    List<String> result;
    //LED灯，前四个为小时，后六个为分钟
    static int[] nums=new int[]{8,4,2,1,32,16,8,4,2,1};
    public List<String> readBinaryWatch(int num) {
        result=new ArrayList<String>();
        //判断输入
        if(num<0)
            return result;

        backTrack(num,0,0,0);
        return result;
    }
    public void backTrack(int num,int start,int hour,int minute){
        if(num==0){
            //判断时间是否正确
            if(hour>11||minute>59)
                return;
            StringBuilder tmp=new StringBuilder();
            //小时
            tmp.append(hour);
            tmp.append(":");
            //分钟
            if(minute<10)
                tmp.append(0);
            tmp.append(minute);
            result.add(new String(tmp));
            return ;
        }
        for(int i=start;i<nums.length;i++){
            /*回溯做选择*/
            //判断是小时还是分钟
            if(i<4)//小时
                hour+=nums[i];
            else
                minute+=nums[i];
            //递归
            backTrack(num-1,i+1,hour,minute);
            /*回溯取消选择*/
            if(i<4)//小时
                hour-=nums[i];
            else
                minute-=nums[i];
        }
    }
}
