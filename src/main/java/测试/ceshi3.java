package 测试;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ceshi3 {
    public static void main(String[] args) {
        List<Map<String,Object>> list=new ArrayList<>();
        Student s1 = new Student("name1");
        Student s2 = new Student("name2");
        Student s3 = new Student("name3");
        Map<String,Object> map1=new HashMap<>();
        map1.put("student1",s1);
        Map<String,Object> map2=new HashMap<>();
        map2.put("student1",s2);
        Map<String,Object> map3=new HashMap<>();
        map3.put("student1",s3);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        for(Map<String,Object> m:list){
            m.put("flag","1");
            System.out.println(m);
        }
        for(Map<String,Object> m:list){
            System.out.println(m);
        }
    }
}
