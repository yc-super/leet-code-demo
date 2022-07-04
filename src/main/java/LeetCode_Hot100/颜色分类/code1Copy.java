package LeetCode_Hot100.颜色分类;

//循环不变量
public class code1Copy {
    public static void main(String[] args) {
//        int[] nums = {2,0,2,1,1,0};
        int[] nums = {1,1,1,0,2,1};
        new code1Copy().sortColors(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }

    }
    public void sortColors(int[] nums) {
        /*
        * [0,zero):全部是0
        * [zero,i):全部是1
        * [two,len-1):全部是2
        * */
        int zero=0,i=0;
        int two=nums.length;
        while (i < two) {
            if(nums[i]==0){
                swap(nums,i,zero);
                i++;
                zero++;
            }else if(nums[i]==1){
                i++;
            }else{
                two--;
                swap(nums,i,two);
            }

        }
    }
    private void swap(int[] nums,int i,int j){
        int index=nums[i];
        nums[i]=nums[j];
        nums[j]=index;

    }
}
