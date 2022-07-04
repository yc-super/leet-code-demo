package LeetCode_Hot100.颜色分类;
/*
* 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

我们使用整数 0、  1 和 2 分别表示红色、白色和蓝色。

必须在不使用库的sort函数的情况下解决这个问题。
*
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
*
* 输入：nums = [2,0,1]
输出：[0,1,2]
* 
* n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2
* */
public class MyCode {
    public static void main(String[] args) {
        int[] nums = {2};
        new MyCode().sortColors(nums);
        for(int i:nums){
            System.out.print(i+",");
        }

    }
    public void sortColors(int[] nums) {
        int count0=0;
        int count1=0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                count0++;
            }else if(nums[i]==1){
                count1++;
            }
        }
        for (i = 0; i < count0; i++) {
            nums[i]=0;
        }
        for (i = count0; i < count0+count1; i++) {
            nums[i]=1;
        }
        for (i = count0+count1; i < nums.length; i++) {
            nums[i]=2;
        }
    }
}
