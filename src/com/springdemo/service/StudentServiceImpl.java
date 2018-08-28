package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.StudentDAO;
import com.springdemo.entity.Student;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student thestudent) {
		studentDAO.saveStudent(thestudent);
		
	}

	@Override
	@Transactional
	public Student getStudent(int theId) {
	
		return studentDAO.getStudent(theId);
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {
	
		studentDAO.deleteStudent(theId);
		
	}

	@Override
	@Transactional
	public List<Student> searchStudents(String theSearchName) {
		// TODO Auto-generated method stub
		return studentDAO.searchStudents(theSearchName);
	}

	
}
