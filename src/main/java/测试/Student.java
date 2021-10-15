package 测试;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
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
}
