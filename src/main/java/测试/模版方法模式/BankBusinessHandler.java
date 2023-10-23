package 测试.模版方法模式;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;
// https://mp.weixin.qq.com/s/zpScSCktFpnSWHWIQem2jg
public class BankBusinessHandler {

    private void execute(Consumer<BigDecimal> consumer) {

        getNumber();

        consumer.accept(null);

        judge();

    }

    private void getNumber() {

        System.out.println("number-00" + new Random().nextInt());

    }

    private void judge() {

        System.out.println("give a praised");

    }

    public void save(BigDecimal amount) {

        execute(a -> {
            System.out.println("save " + amount);
            System.out.println("123123");
        });

    }


    public static void main(String[] args) {
        BankBusinessHandler handler = new BankBusinessHandler();
        handler.save(new BigDecimal(100));

    }

}