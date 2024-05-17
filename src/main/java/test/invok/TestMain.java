package test.invok;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class TestMain {

    private static org.springframework.context.ApplicationContext applicationContext;

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Object bean = applicationContext.getBean("studentController");
        Method[] methods = bean.getClass().getMethods();
//        Class<?> aClass = Class.forName("测试.invok.StudentController");
//        Method[] methods = aClass.getMethods();
        for(Method method:methods){
            if(method.getName().equals("tt")){
                Object invoke = method.invoke(bean, "111");
                String s = JSONObject.toJSONString(invoke);
                System.out.println(s);
            }
        }
    }
}
