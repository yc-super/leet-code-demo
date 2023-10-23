package 测试.ABA问题;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABATest {
//    private AtomicStampedReference
    public static void main(String[] args) {
        int a=3;
        a*=1+2;
        System.out.println(a);
    }
}
