package 代码随想录.哈希表专练.快乐数;

import java.util.HashSet;
import java.util.Set;

public class code {
    public static void main(String[] args) {
        int n=2;
        System.out.println(new code().isHappy(n));
    }
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        set.add(n);
        while(n!=1) {
            n = getNextNum(n);
            if (set.contains(n)) {
                return false;
            }else{
                set.add(n);
            }
        }
        return true;
    }

    private int getNextNum(int n) {
        int result=0;
        int index_value=0;
        while(n!=0){
            index_value=n%10;
            result+=index_value*index_value;
            n/=10;
        }
        return result;
    }
}
