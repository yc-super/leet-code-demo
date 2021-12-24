package LeetCode.一年当中的第几天;

public class code {
    public static void main(String[] args) {
//       String date = "2019-01-09";
//       String date = "2019-02-10";
       String date = "2000-03-01";
        System.out.println(new code().dayOfYear(date));

    }
    public int dayOfYear(String date) {
        int[] dayNum={31,28,31,30,31,30,31,31,30,31,30,31};
        String[] split = date.split("-");

        int year=Integer.parseInt(split[0]);
        int month=Integer.parseInt(split[1]);
        int day=Integer.parseInt(split[2]);

        int sum=0;
        for (int i = 0; i < month-1; i++) {
            sum+=dayNum[i];
        }
        sum+=day;
        //如果是闰年且月份大于3，则+1，
        if((year%400==0||(year%4==0&&year%100!=0))&&month>2){
            sum+=1;
        }
        return sum;
    }
}
