package LeetCode.吃苹果的最大数目;

public class code {
    public static void main(String[] args) {
//       int[] apples = {1,2,3,5,2}, days = {3,2,1,4,2};
//       int[] apples = {3,0,0,0,0,2}, days = {3,0,0,0,0,2};
//       int[] apples = {0,1}, days = {1,1};
       int[] apples = {2,1,1,4,5}, days = {10,10,6,4,2};//8
        System.out.println(new code().eatenApples(apples,days));
    }
    //1 2   3   4   5   6   7
    //[1    ]
    // [1   1]
    //     1,1,1
    //          1   1   1   1,1
    //              1   1

    //3,3,3,7,6
    public int eatenApples(int[] apples, int[] days) {
        for (int i = 0; i < days.length; i++) {
            days[i]=days[i]+i-1;
        }
        int sum=0;
        int j=0;
        int min;
        int day=0;
        for (int i = 0; i < days.length; i++) {
            if(days[i]>day){
                day=days[i];
            }
        }
        //从第0天遍历至apples.length天
        for (int i = 0; i <= day; i++) {
//            index=0;
            //找到第一个apples[i]不为0,并且天数大于等于今天（i）下标
            while(j<apples.length&&(apples[j]==0||days[j]<i)){
                j++;
            }
            min=j;
            //遍历i后面的截止天数，从中找到最小的截止天数（并且当天要有apple）
            for (int k = min+1; k < days.length; k++) {
                if(days[k]>=i&&days[k]<days[min]&&apples[k]!=0){
                    min=k;
                }
            }
            if(min!=apples.length){
                apples[min]-=1;
                sum++;
            }
        }
        return sum;
    }
}
