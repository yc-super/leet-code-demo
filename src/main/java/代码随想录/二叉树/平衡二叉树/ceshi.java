package 代码随想录.二叉树.平衡二叉树;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ceshi {
    public static void main(String[] args) {
        String str = "{\"name\":\"yc\",\"age\":\"22\"}";
        // 1.JSON字符串转JSONObject
        JSONObject object = JSONObject.parseObject(str);
        String name = object.getString("name");
        int age = object.getInteger("age");
        System.out.println(name);// yc
        System.out.println(age);// 22

        // 2. JSON字符串转对象，可以是Map，也可以是Student等自定义对象
        Map<String, String> map = JSONObject.parseObject(str, Map.class);
        String name1 = map.get("name");
        int age1 = Integer.valueOf(map.get("age"));
        System.out.println(name1);// yc
        System.out.println(age1);// 22

        // 3. 对象转JSON字符串，除了map还可以是Student等
        String s = JSON.toJSONString(map);
        System.out.println(s);// {"name":"yc","age":"22"}

        // 4. JSON字符串转List
        String str2 = "[{\"name\":\"yc\",\"age\":\"22\"},{\"name\":\"yc\",\"age\":\"22\"}]";
        List<Student> object1 = JSONArray.parseObject(str2, List.class);
        System.out.println(object1);// [{"name":"yc","age":"22"}, {"name":"yc","age":"22"}]
        System.out.println(JSON.toJSONString(object1));// [{"name":"yc","age":"22"},{"name":"yc","age":"22"}]

        // 5. JSON字符串转List2
        String str3 = "[\"str1\",\"str2\",\"str3\"]";
        JSONArray jsonArray1 = JSONArray.parseArray(str3);
        String[] strings = jsonArray1.toArray(new String[0]);
        for (String sss : strings) {
            System.out.println(sss);// str1,str2,str3
        }

        // 6. 复杂JSON字符串获取数据
        String ss = "{\"code\":\"200\",\"result\":[{\"name\":\"yc1\",\"age\":\"22\"},{\"name\":\"yc\",\"age\":\"22\"}]}";
        JSONObject jsonObject2 = JSONObject.parseObject(ss);
        int code = jsonObject2.getInteger("code");// 200
        JSONArray jsonArray = jsonObject2.getJSONArray("result");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);//利用下标获取jsonArray中的对象
            String name2 = jsonObject.getString("name");// yc1、yc
            Integer age2 = jsonObject.getInteger("age");// 22
            System.out.println();
        }
        Arrays.asList(1,2);
    }
}

class Student {
    private String name;
    private int age;
}
