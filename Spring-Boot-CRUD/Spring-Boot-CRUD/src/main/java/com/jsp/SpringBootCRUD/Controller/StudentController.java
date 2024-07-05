package com.jsp.SpringBootCRUD.Controller;

import java.util.List;
import java.util.Optional;

import com.jsp.SpringBootCRUD.Dto.ResponseStructure;
import com.jsp.SpringBootCRUD.Dto.StudentShift;
import com.jsp.SpringBootCRUD.Service.StudentShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jsp.SpringBootCRUD.Dto.Student;
import com.jsp.SpringBootCRUD.Service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	StudentShiftService studentShiftService;

	// List all students
	/*@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("students", studentService.getAllStudent().getData());
		return "index";
	}*/

	// Show form for adding a new student
	@GetMapping("/student/new")
	public String createStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "student_form";
	}

	// Show form for editing an existing student
	@GetMapping("/student/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		Student student = studentService.getStudentById(id).getData();
		model.addAttribute("student", student);
		return "student_form";
	}

	// Save student (both create and update)
	@PostMapping("/student/save")
	public String saveStudent(Student student) {
		studentService.saveStudent(student);
		return "redirect:/";
	}

	// Delete student
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "redirect:/";
	}

	@GetMapping("/schedule")
	public String viewSchedule(Model model) {
		ResponseStructure<List<Student>> students = studentService.getAllStudent();
		model.addAttribute("students", students);
		return "schedule";
	}
}
