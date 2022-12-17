package 测试;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private Integer age;
    private Integer mathScore;
    public Student(String name){
        this.name=name;
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
