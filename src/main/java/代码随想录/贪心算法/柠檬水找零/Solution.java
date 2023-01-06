package 代码随想录.贪心算法.柠檬水找零;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int a=0,b=0,c=0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                a++;
            }else if(bills[i]==10){
                b++;
                if(a<1)
                    return false;
                a--;
            }else{
                c++;
                if(b>0&&a>0){
                    b--;
                    a--;
                }else if(a>2){
                    a-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
