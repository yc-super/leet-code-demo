package LeetCode.解码异或后的数组;
/*
* 输入：encoded = [1,2,3], first = 1
输出：[1,0,2,1]
解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
*
* */
public class MyCode {
    public static void main(String[] args) {
        int[] encoded={1,2,3};
        int first=1;
        int[] result=decode(encoded,first);
        for (int a:result){
            System.out.println(a);
        }
    }
    public static int[] decode(int[] encoded, int first) {
        int length=encoded.length;
        int[] array=new int[length+1];
        array[0]=first;
        for (int i = 0; i < length; i++) {
            array[i+1]=array[i]^encoded[i];
        }
        return array;
    }
}
