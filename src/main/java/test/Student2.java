package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2{
    private String id;
    private String name;
    private Integer age;
    private Integer mathScore;
    public Student2(String name){
        this.name=name;
    }
    Student2 s;
    public Student2(String name, Student2 s){
        this.name=name;
        this.s=s;
    }
    public Student2(Integer age){
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

}
