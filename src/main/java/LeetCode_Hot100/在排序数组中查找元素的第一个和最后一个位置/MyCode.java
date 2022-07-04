package LeetCode_Hot100.在排序数组中查找元素的第一个和最后一个位置;

public class MyCode {
    public static void main(String[] args) {
        int[] nums={7};
        int target=7;
        int[] ints = new MyCode().searchRange(nums, target);
        System.out.println(ints[0]+","+ints[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        int len=nums.length;
        if(len==0)
            return result;
        /*if(len==1){
            if(nums[0]==target){
                result[0]=0;
                result[1]=0;
            }
            return result;
        }*/
        int l=0,r=len-1;
        int mid=0;
        while (l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target) {
                break;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        if(nums[mid]!=target) {
            return result;
        }
        l=r=mid;
        while(l-1>=0&&nums[l-1]==target){
            l--;
        }
        while(r+1<len&&nums[r+1]==target){
            r++;
        }
        result[0]=l;
        result[1]=r;
        return result;
    }
}
