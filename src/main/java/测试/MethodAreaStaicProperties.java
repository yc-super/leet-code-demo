package 测试;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Vector;

public class MethodAreaStaicProperties {


    public static MethodAreaStaicProperties m;

    public MethodAreaStaicProperties(String name) {}

    public static void testGC(){

    }

    @Override
    public void finalize() throws Throwable{
        System.out.println("要死了要死了！");
    }

    public static void main(String[] args) {
        MethodAreaStaicProperties s = new MethodAreaStaicProperties("properties");
        s.m = new MethodAreaStaicProperties("parameter");

        System.out.println("properties:"+s);
        System.out.println("parameter:"+s.m);

        s = null;
        System.gc();

        System.out.println("properties:"+s);
        System.out.println("parameter:"+s.m);
    }
}
