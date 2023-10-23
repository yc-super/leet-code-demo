package LeetCode.只出现一次的数字III;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int i = Integer.numberOfTrailingZeros(temp);
        int[] result = new int[2];
        for (int num : nums) {
            result[num >>> i & 1] ^= num;
        }
        return result;
    }
    public int[] singleNumber2(int[] nums) {
        int xorAll = 0;
        for (int x : nums) {
            xorAll ^= x;
        }
        int tz = Integer.numberOfTrailingZeros(xorAll);
        int[] ans = new int[2];
        for (int x : nums) {
            ans[x >>> tz & 1] ^= x;
        }
        return ans;
    }

    public static void main(String[] args) {

//        int i = 170;
        int i = -8;
        System.out.println("Number = " + i);

      /* returns the string representation of the unsigned integer value
         represented by the argument in binary (base 2) */
        System.out.println("Binary = " + Integer.toBinaryString(i));

        // returns the number of one-bits
        System.out.println("Number of one bits = " + Integer.bitCount(i));

      /* returns an int value with at most a single one-bit, in the position
         of the highest-order ("leftmost") one-bit in the specified int value */
        System.out.println("Highest one bit = " + Integer.highestOneBit(i));

      /* returns an int value with at most a single one-bit, in the position
         of the lowest-order ("rightmost") one-bit in the specified int value.*/
        System.out.println("Lowest one bit = " + Integer.lowestOneBit(i));

      /*returns the number of zero bits preceding the highest-order
         ("leftmost")one-bit */
        System.out.print("Number of leading zeros = ");
        System.out.println(Integer.numberOfLeadingZeros(i));

      /* returns the number of zero bits following the lowest-order
         ("rightmost") one-bit */
        System.out.print("Number of trailing zeros = ");
        System.out.println(Integer.numberOfTrailingZeros(i));
    }
}
