package 剑指offer.砍竹子II.砍竹子I;

/*
* 数学相关。不知道为什么，尽量分成长度为3的小段，这样乘积最大
* */
public class Solution {
    public int cuttingBamboo(int bamboo_len) {
        if(bamboo_len<=3)
            return bamboo_len-1;
        int count=bamboo_len/3;
        int b=bamboo_len%3;
        long res=1,a=1000000007;;
        for (int i = 1; i < count; i++) {
            res=res*3%a;
        }
        if(b==0){
            res=res*3%a;
        }else if(b==1) {
            res = res * 4 % a;
        }else{
            res = res * 6 % a;
        }
        return (int)res;
    }
}
