package com.jsp.SpringBootCRUD.Service;

import com.jsp.SpringBootCRUD.Dto.StudentShift;
import com.jsp.SpringBootCRUD.Repository.StudentShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentShiftService {

    @Autowired
    StudentShiftRepository studentShiftRepository;

    public List<StudentShift> getAllShifts() {
        return studentShiftRepository.findAll();
    }

    public Optional<StudentShift> getShiftById(int id) {
        return studentShiftRepository.findById(id);
    }

    public StudentShift saveShift(StudentShift shift) {
        return studentShiftRepository.save(shift);
    }

    public void deleteShift(int id) {
        studentShiftRepository.deleteById(id);
    }
}

