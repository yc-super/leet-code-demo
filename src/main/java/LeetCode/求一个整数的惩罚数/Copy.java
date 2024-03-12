package LeetCode.求一个整数的惩罚数;

public class Copy {

    public static void main(String[] args) {
        int i = new Copy().punishmentNumber(36);
        System.out.println();
    }
    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i, i * i)) {
                result += i * i;
            }
        }
        return result;
    }

    private boolean check(int i, int ii) {
        if (ii < i) {
            return false;//// s 比 n 小，拆位之后的总和只会比 n 更小
        }
        if (i == ii) {
            return true;
        }
        for (int j = 10; j <= ii; j *= 10) {
            if (check(i - ii % j,ii / j)) {
                return true;
            }
        }
        return false;
    }
    // 其实可以去掉 s < n 的判断，让代码更精简。
    // 因为如果 s < n，就算进入后续的循环和递归，也一样不会返回 true，不影响最终结果。
    // 留下 s < n 的好处是可以提前中止后续没必要的循环和递归。
}
