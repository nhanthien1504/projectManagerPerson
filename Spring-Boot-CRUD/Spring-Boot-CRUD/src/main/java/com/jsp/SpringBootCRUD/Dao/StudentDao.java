package com.jsp.SpringBootCRUD.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.SpringBootCRUD.Dto.Student;
import com.jsp.SpringBootCRUD.Repository.StudentRepository;

@Repository
public class StudentDao {

	private final StudentRepository studentRepository;

	@Autowired(required = false)
	public StudentDao(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	// save student
	public Student saveStudent(Student staudent) {
		return studentRepository.save(staudent);
	}
	
	// get student by id
	public Student getStudentById(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if(optional ==null) {
			return null;
		} else return optional.get();
	}
	
	// get all students
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	// update student
	public Student updateStudent(Student student, int id) {
		Student existingstudent = getStudentById(id);
		if(existingstudent != null) {
			existingstudent.setName(student.getName());
			existingstudent.setPhone(student.getPhone());
			return studentRepository.save(existingstudent);
		} else return null;
	}
	
	// delete student
	public Boolean deleteStudent(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
			return true;
		} else return false;
	}
}