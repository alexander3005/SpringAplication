package app.student.controller;
import app.student.dao.StudentDao;
import app.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class StudentController {
    
@Autowired
StudentDao studentDao;

    @RequestMapping("/studentList")
    public String StudentList(ModelMap model) throws SQLException {
        model.addAttribute("students", studentDao.getStudentList());
        return "studentList";
}
    @RequestMapping("/addStudent")
public String insert(@ModelAttribute Student  student){

    studentDao.insert(student);
    return "redirect:/studentList";}

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String newStudent(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student",student);
       return "registration";
    }
    @RequestMapping("/edit")
    public String editStudent(ModelMap modelMap,HttpServletRequest request){
int studentId = Integer.parseInt(request.getParameter("id"));
        Student student = studentDao.getStudent(studentId);
        modelMap.addAttribute("student",student);
        return "edit";
    }
    @RequestMapping("/update")
    public  String updateStudent(@ModelAttribute Student student){
        studentDao.update(student);
        return "redirect:/studentList";
    }
    @RequestMapping("/delete")
    public String deleteStudent(HttpServletRequest request){
        int studentId=Integer.parseInt(request.getParameter("id"));
        studentDao.delete(studentId);
        return "redirect:/studentList";
    }
}