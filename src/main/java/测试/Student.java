package 测试;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.core.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{
    private String id;
    private String name="xiaoming";
    private Integer age=88;
    private Integer mathScore;
    public Student(String name){
        this.name=name;
    }
    public Student(String name,Integer age){
        this.name=name;
        this.age=age;
    }
    Student s;
    public Student(String name,Student s){
        this.name=name;
        this.s=s;
    }
    public Student(Integer age){
        this.age=age;
    }
    @Override
    public int hashCode(){
        int result=17;
        result=31*result+id==null?0:id.hashCode();
        result=31*result+name==null?0:name.hashCode();
        result=31*result+age;
        return result;
    }

    @Override
    public int compareTo(Student o) {
        return this.age-o.age;
    }
}
