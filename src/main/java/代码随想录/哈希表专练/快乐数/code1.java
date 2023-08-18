package 代码随想录.哈希表专练.快乐数;

import java.util.HashSet;
import java.util.Set;

public class code1 {
    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(n));
    }
    public static boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(true) {
            set.add(n);
            int result = getResult(n);
            if(result==1)
                return true;
            if (set.contains(result)) {
                return false;
            }
            n=result;
        }
    }

    private static int getResult(int n) {
        int result=0;
        while(n!=0){
            result=result+((n%10)*(n%10));
            n/=10;
        }
        return result;
    }
}
