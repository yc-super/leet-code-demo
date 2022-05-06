package Hot100.跳跃游戏;

/*
* 动态规划一遍循环，判断能否到达最后一个元素，就是判断倒数第二个能否到达倒数第一个元素，如果不能就是判断倒数第三个元素能否到达倒数第一个元素，
* 如果能到达就是判断倒数第三个元素能否到达倒数第二个元素
* */
public class code {
    public static void main(String[] args) {
//        int[] nums= {2,3,1,1,4};
//        int[] nums= {1,1,2,0,0,1,1,2,0,1};
        int[] nums= {100,1,2,0,0,1,1,2,0,1};
        boolean b = new code().canJump(nums);
        System.out.println(b);
    }
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 1) return true;
        int minStep = 1;        //定义一个数，为达到最后最后一个结点最小需要的步数
        for (int i = length-2; i >0; i--) {          //从倒数第二个往第二个开始遍历
            if (nums[i]<minStep){            // 如果当前元素的值小于最小步数,则到达最后一个元素的最小步数+1;
                minStep++;
            }else {
                minStep = 1;              //如果当前元素的值大于或等于最小步数，则一定能到达最后一个元素，
                // 此时可以就当前元素认为是最后一个元素，并对于前一个元素来说最小步数为1;
            }
        }

        return nums[0] >= minStep;       //此时minStep为达到"最后一个元素"(并不是nums[length-1])的最小步数，只要判断第一个元素的值是否大于或等于最小步数就可以了;
    }
}
