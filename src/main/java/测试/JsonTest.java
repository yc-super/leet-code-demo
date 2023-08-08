package 测试;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

public class JsonTest {
    public static void main(String[] args) {
        String s="{\"name\":\"yc\",\"age\":\"18\"}";
        JSONObject object = JSONObject.parseObject(s);
        System.out.println(object);


        String[] ll=new String[4];
        Arrays.fill(ll,"");
        System.out.println();
    }
}
