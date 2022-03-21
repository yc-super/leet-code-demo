package 测试;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
public class ceshi6 {
    public static void main(String[] args) throws Exception {
           if("ss".equals(null)){
               System.out.println(123);
           }else{
               System.out.println(45);
           }


    }
    public static Map<String,Object> Obj2Map(Object obj) throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }
    static class Student{
        private String name;
        private Integer age;
        public Student(String name,Integer age){
            this.name=name;
            this.age=age;
        }
        public String getName(){
            return name;
        }
        public Integer getAge(){
            return age;
        }
    }

    private static void getff(Map<String, String> map) {
        map.remove("1");
    }
}

