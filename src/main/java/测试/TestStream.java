package 测试;

import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
//        List<Map> mapList = new ArrayList<>();
//        Map<String, String> map1 = new HashMap() {
//            {
//                put("11","111");
//                put("12","122");
//            }
//        };
//        Map<String, String> map2 = new HashMap() {
//            {
//                put("21","211");
//                put("22","222");
//            }
//        };
//        mapList.add(map1);
//        mapList.add(map2);


        List<String> list=new ArrayList<>();
        list.subList(0,list.size());
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<String> strings = list.subList(4,2);
//        System.out.println();
        System.out.println(strings);
    }

}
