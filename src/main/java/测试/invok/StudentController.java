package 测试.invok;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 测试.Student;

@RestController
@RequestMapping("/stu")
public class StudentController {

    public String getStudent(Student student){
        return student.toString();
    }
}
