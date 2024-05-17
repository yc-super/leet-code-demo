package test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test1 {
    public static void main(String[] args) {
//        String format = LocalDateTime.now().minusDays(6).format(DateTimeFormatter.ofPattern("yyyy-MM-dd 23:59:59"));
//        System.out.println(format);

        BigDecimal b1 = BigDecimal.valueOf(12);
        BigDecimal b2 = BigDecimal.valueOf(4);
        BigDecimal b3 = BigDecimal.valueOf(2);
        BigDecimal multiply = b1.multiply(b2).multiply(b3);
        System.out.println(multiply);
    }
}
