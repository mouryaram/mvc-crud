package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.Student;

public interface StudentDAO {
	public List<Student> getStudents();

	public void saveStudent(Student thestudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);

	public List<Student> searchStudents(String theSearchName);

}
