package test.invok;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.Student;

@RestController
@RequestMapping("/stu")
public class StudentController {

    public String getStudent(Student student){
        return student.toString();
    }
}
