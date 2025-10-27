package com.jsp.SpringBootCRUD.Controller;

import com.jsp.SpringBootCRUD.Dto.ResponseStructure;
import com.jsp.SpringBootCRUD.Dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.SpringBootCRUD.Service.StudentService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        // Fetch all students
        ResponseStructure<List<Student>> response = studentService.getAllStudent();
        List<Student> students = response.getData();

        // Add students to the model
        model.addAttribute("students", students);

        // Return the Thymeleaf template name
        return "index";
    }
}
